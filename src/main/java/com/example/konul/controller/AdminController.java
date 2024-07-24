//package com.example.konul.controller;
//
//import com.example.konul.service.Impl.UserSecurityService;
//import com.example.konul.service.OrderService;
//import com.example.konul.service.ProductService;
//import com.example.konul.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private ProductService productService;
//@Autowired
//private UserSecurityService userSecurityService;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/adminHome")
//    public String adminHome(Model model,Long id) {
//        // Логика для загрузки домашней страницы администратора
//      //  int totalOrders = orderService.findOrderWithDetails(id);
//      //  int totalProducts = productService.findAllProducts();
//      //  int totalUsers = userService.countTotalUsers();
//
//        model.addAttribute("totalOrders", orderService.findOrderWithDetails(id));
//       // model.addAttribute("totalProducts",productService. );
//        model.addAttribute("totalUsers", userService.findByUserName(getClass().getName()));
//        model.addAttribute("pageTitle", "Admin Home");
//
//        return "/admin"; // Имя шаблона для домашней страницы администратора
//    }
//}
