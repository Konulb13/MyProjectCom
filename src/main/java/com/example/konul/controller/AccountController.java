package com.example.konul.controller;
import com.example.konul.entity.Address;
import com.example.konul.entity.Order;
import com.example.konul.entity.User;
import com.example.konul.service.Impl.UserSecurityService;
import com.example.konul.service.OrderService;
import com.example.konul.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.SecurityUtil;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class AccountController {

    @Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/login")
    public String login(Model model) {
      log.info("Model has come Usename {}, email {},{}",model.asMap().get("username"),model.asMap().get("email"),123);
        model.addAttribute("usernameExist",model.asMap().get("usernameExist"));
        model.addAttribute("emailExist",model.asMap().get("emailExist"));
        return "myAccount";
    }
    @RequestMapping("/my-profile")
    public String myProfile(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "myProfile";
    }

    @RequestMapping("/my-orders")
    public String myOrders(Model model,Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        log.info("My user {}",user.toString());
        model.addAttribute("user", user);
        List<Order> orders = orderService.findByUser(user);
        model.addAttribute("orders", orders);
        return "myOrders";
    }
    @RequestMapping("/my-address")
    public String myAddress(Model model,Principal principal) {
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("user", user);
        return "myAddress";
    }

    @RequestMapping(value="/update-user-address",method = RequestMethod.POST)
    public String updateUserAddress(@ModelAttribute("address") Address address, Model model, Principal principal)throws Exception{
        User currentUser = userService.findByUserName(principal.getName());
        if(currentUser==null){
            throw new Exception("User not found");
        }
        currentUser.setAddress(address);
        userService.save(currentUser);
        return "redirect:/my-address";
    }
    @RequestMapping(value = "/new-user",method = RequestMethod.POST)
    public String newUserPost(@Valid @ModelAttribute("user")User user, BindingResult bindingResult,
                              @ModelAttribute("new-password")String password,
                              RedirectAttributes redirectAttributes,Model model){
        model.addAttribute("email",user.getEmail());
        model.addAttribute("username",user.getUsername());
        boolean invalidFields =false;
        if(bindingResult.hasErrors()){
            return "redirect:/login";
        }
        if(userService.findByUserName(user.getUsername()) != null){
            redirectAttributes.addFlashAttribute("usernameExist",true);
            invalidFields = true;
        }
        if(userService.findByEmail(user.getEmail()) != null){
            redirectAttributes.addFlashAttribute("emailExist",true);
            invalidFields =true;
        }
        if (invalidFields){
            return "redirect:/login";
        }
        user=userService.createUser(user.getUsername(),password,user.getEmail(), Arrays.asList("ROLE_USER"));
        userSecurityService.authenticateUser(user.getUsername());
        return "redirect:/my-profile";
    }

    @RequestMapping(value="/update-user-info", method=RequestMethod.POST)
    public String updateUserInfo( @ModelAttribute("user") User user,
                                  @RequestParam("newPassword") String newPassword,
                                  Model model, Principal principal) throws Exception {
        User currentUser = userService.findByUserName(principal.getName());
        if(currentUser == null) {
            throw new Exception ("User not found");
        }
        /*check username already exists*/
        User existingUser = userService.findByUserName(user.getUsername());
        if (existingUser != null && !existingUser.getId().equals(currentUser.getId()))  {
            model.addAttribute("usernameExists", true);
            return "myProfile";
        }
        /*check email already exists*/
        existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null && !existingUser.getId().equals(currentUser.getId()))  {
            model.addAttribute("emailExists", true);
            return "myProfile";
        }
        /*update password*/
        if (newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")){
            BCryptPasswordEncoder passwordEncoder = SecurityUtil.passwordEncoder();
            String dbPassword = currentUser.getPassword();
            if(passwordEncoder.matches(user.getPassword(), dbPassword)){
                currentUser.setPassword(passwordEncoder.encode(newPassword));
            } else {
                model.addAttribute("incorrectPassword", true);
                return "myProfile";
            }
        }
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setUserName(user.getUsername());
        currentUser.setEmail(user.getEmail());
        userService.save(currentUser);
        model.addAttribute("updateSuccess", true);
        model.addAttribute("user", currentUser);
        userSecurityService.authenticateUser(currentUser.getUsername());
        return "myProfile";
    }
    @RequestMapping("/order-detail")
    public String orderDetail(@RequestParam("order")Long id,Model mode){
        Order order = orderService.findOrderWithDetails(id);
        mode.addAttribute("order", order);
        return "orderDetails";
    }
}
