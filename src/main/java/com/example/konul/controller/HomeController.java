package com.example.konul.controller;

import com.example.konul.entity.Product;
import com.example.konul.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Product> products = productService.findFirstProduct();
        model.addAttribute("products", products);
        return "index";
    }
}
