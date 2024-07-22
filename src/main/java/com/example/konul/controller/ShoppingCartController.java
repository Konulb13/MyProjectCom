package com.example.konul.controller;

import com.example.konul.entity.CartItem;
import com.example.konul.entity.Product;
import com.example.konul.entity.ShoppingCart;
import com.example.konul.entity.User;
import com.example.konul.service.ProductService;
import com.example.konul.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/cart")
    public String shoppingCart(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(user);
        model.addAttribute("cartItemList",shoppingCart.getCartItems());
        model.addAttribute("shoppingCart",shoppingCart);
        //
        System.out.println("shoppingCart"+shoppingCart);
        System.out.println("cartItemList"+shoppingCart.getCartItems());
        return "shoppingCart";
    }
    @RequestMapping("/add-item")
    public String addItem(@ModelAttribute("product") Product product, @RequestParam("qty")String qty,
                          @RequestParam("size")String size,
                          RedirectAttributes redirectAttributes,Model model,Authentication authentication) {
        product= productService.findProductById(product.getId());
        if(!product.hasStock(Integer.parseInt(qty))) {
            redirectAttributes.addFlashAttribute("notEnoughStock",true);  //???
            return "redirect:/article-detail?id="+product.getId();
        }
        User user = (User) authentication.getPrincipal();
        shoppingCartService. addProductToShoppingCart(product,user,Integer.parseInt(qty),size);
        redirectAttributes.addFlashAttribute("addProductSuccess",true);
        return "redirect:/product-detail?id="+product.getId();
    }

//    @RequestMapping("/add-item")
//    public String addItem(@ModelAttribute("product") Product product, @RequestParam("qty") String qty,
//                          @RequestParam("size") String size, RedirectAttributes redirectAttributes,
//                          Model model, Authentication authentication) {
//        product = productService.findProductById(product.getId());
//        int quantity = Integer.parseInt(qty);
//
//        if (!product.hasStock(quantity)) {
//            redirectAttributes.addFlashAttribute("notEnoughStock", true);
//            return "redirect:/article-detail?id=" + product.getId();
//        }
//
//        User user = (User) authentication.getPrincipal();
//        shoppingCartService.addProductToShoppingCart(product, user, quantity, size);
//        redirectAttributes.addFlashAttribute("addProductSuccess", true);
//        return "redirect:/product-detail?id=" + product.getId();
//    }

    @RequestMapping("/update-item")
    public String updateItemQuantity(@RequestParam("id")Long cartItemId,
                                     @RequestParam("qty")Integer quantity,Model model) {
        CartItem cartItem = shoppingCartService.findCartItemById(cartItemId);
        if (cartItem.canUpdateQuantity(quantity)){
            shoppingCartService.updateCartItem(cartItem,quantity);
        }
        return "redirect:/shopping-cart/cart";
    }
    @RequestMapping("/remove-ietm")
    public String removeItem(@RequestParam("id")Long id){
        shoppingCartService.removeCartItem(shoppingCartService.findCartItemById(id));
        return "redirect:/shopping-cart/cart";
    }
}
