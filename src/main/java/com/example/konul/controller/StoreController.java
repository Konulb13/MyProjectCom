package com.example.konul.controller;

import com.example.konul.entity.Product;
import com.example.konul.filter.SortFilter;
import com.example.konul.form.ProductFilterForm;
import com.example.konul.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/store")
    public String store(@ModelAttribute("filters") ProductFilterForm filters, Model model) {
        Integer page = filters.getPage();
        int pageNumber = (page == null || page < 1) ? 1 : page;  //      (page == null ) ?0 : page;
        SortFilter sortFilter = new SortFilter(filters.getSort());
        Page<Product> pageresult = productService.findProductsByCriteria(PageRequest.of(pageNumber, 8, sortFilter.getSortType()),
                filters.getPriceLow(), filters.getPriceHigh(), filters.getSize(),filters.getCategory(),filters.getBrand(),filters.getSearch());
        model.addAttribute("allCategories",productService.getAllCategories());
        model.addAttribute("allBrands",productService.getAllBrands());
        model.addAttribute("allSizes",productService.getAllSizes());
        model.addAttribute("totalitems",pageresult.getTotalElements());
        model.addAttribute("itemsperpage",8);
        return "store";
    }

    @RequestMapping("/product-detail")
    public String productDetail(@PathParam("id")Long id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("notEnoughStock",model.asMap().get("notEnoughStock"));
        model.addAttribute("addProductSuccess",model.asMap().get("addProductSuccess"));
        return "productDetail";
    }

}
