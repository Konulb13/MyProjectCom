package com.example.konul.service;
import com.example.konul.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Page<Product> findProductsByCriteria(Pageable pageable, Integer price_low, Integer price_high,
                                                             List<String> sizes, List<String> categories, List<String> brands, String search);

    List<Product> findFirstProduct();

    Product findProductById(Long id);

    Product saveProduct(Product product);

    void deleteProductById(Long id);

    List<String> getAllSizes();

    List<String> getAllCategories();

    List<String> getAllBrands();

}
