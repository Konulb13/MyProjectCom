package com.example.konul.controller;
import com.example.konul.entity.*;
import com.example.konul.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.List;
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("allSizes", productService.getAllSizes());
        model.addAttribute("allBrands", productService.getAllBrands());
        model.addAttribute("allCategories", productService.getAllCategories());
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
        Product newProduct = new ProductBuilder()
                .withTitle(product.getTitle())
                .stockAvailable(product.getStock())
                .withPrice(product.getPrice())
                .imageLink(product.getPicture())
                .sizesAvailable(Arrays.asList(request.getParameter("size").split("\\s* ,\\s*")))
                .ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))
                .ofBrand(Arrays.asList(request.getParameter("brand").split("\\s*,\\s*")))
                .build();
        productService.saveProduct(newProduct);
        return "redirect:product-list";
    }

    @RequestMapping("/product-list")
    public String productList(Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/edit")
    public String editProduct(@RequestParam("id") Long id, Model model) {
        Product product = productService.findProductById(id);
        String preselectedSizes = "";
        for (Size size : product.getSizes()) {
            preselectedSizes = preselectedSizes + (size.getValue() + ",");             //does that work right?
        }
        String preselectedBrands = "";
        for (Brand brand : product.getBrands()) {
            preselectedBrands = preselectedBrands + (brand.getName() + ",");
        }
        String preselectedCategories = "";
        for (Category category : product.getCategories()) {
            preselectedCategories = preselectedCategories + (category.getName() + ",");
        }
        model.addAttribute("product", product);
        model.addAttribute("preselectedSizes", preselectedSizes);
        model.addAttribute("preselectedBrands", preselectedBrands);
        model.addAttribute("preselectedCategories", preselectedCategories);
        model.addAttribute("allSizes", productService.getAllSizes());
        model.addAttribute("allBrands", productService.getAllBrands());
        model.addAttribute("allCategories", productService.getAllCategories());
        return "editProduct";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String EditProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
        Product newProduct = new ProductBuilder()
                .withTitle(product.getTitle())
                .stockAvailable((product.getStock()))
                .withPrice(product.getPrice())
                .imageLink(product.getPicture())
                .sizesAvailable(Arrays.asList(request.getParameter("size").split("\\s*,\\s*")))
                .ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))
                .ofBrand(Arrays.asList(request.getParameter("brand").split("\\s*,\\s*")))
                .build();
        newProduct.setId(product.getId());
        productService.saveProduct(newProduct);
        return "redirect:product-list";
    }
    @RequestMapping("/delete")
    public String deleteProduct(@RequestParam("id")Long id) {
        productService.deleteProductById(id);
        return "redirect:product-list";
    }
}