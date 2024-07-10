package com.example.konul.service.Impl;
import com.example.konul.repository.ProductDescription;
import com.example.konul.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.konul.entity.Product;
import com.example.konul.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Value("9")
    private int featuredProductsNumber;



    @Override
    public List<Product> findAllProducts() {
        return (List<Product>) productRepository.findAllEagerBy();
    }

//    @Override
//    public org.hibernate.query.Page<Product> findProductsByCriteria(java.awt.print.Pageable pageable, Integer priceLow, Integer priceHigh, List<String> sizes, List<String> categories, List<String> brands, String search) {
//        return null;
//    }

    @Override
    public Page<Product> findProductsByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh,
                                                List<String> sizes, List<String> categories, List<String> brands, String search) {
        Page<Product> page = productRepository.findAll(ProductDescription.filterBy(priceLow, priceHigh, sizes, categories, brands, search), pageable);
        return page;
    }

    @Override
    public List<Product> findFirstProduct() {
        return productRepository.findAll(PageRequest.of(0,featuredProductsNumber)).getContent();
    }
    @Override
    public Product findProductById(Long id){
        Optional<Product> opt = productRepository.findById(id);
        return opt.get();}

    @Override
    @CacheEvict(value = {"sizes","categories","brands"},allEntries = true)
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    @Override
    @CacheEvict(value = {"sizes","categories","brands"},allEntries = true)
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    @Cacheable("size")
    public List<String>getAllSizes(){
        return productRepository.findAllSizes();
    }
    @Override
    @Cacheable("categories")
    public List<String>getAllCategories(){
        return productRepository.findAllCategories();
    }
    @Override
    @Cacheable("brands")
    public List<String>getAllBrands(){
        return productRepository.findAllBrands();
    }
}