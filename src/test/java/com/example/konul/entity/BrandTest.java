package com.example.konul.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrandTest {

    private Brand brand;
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
        product.setId(1L);
        product.setTitle("Sample Product");
        product.setPrice(100.0);
        product.setStock(10);
        product.setPicture("sample.jpg");

        brand = new Brand("BrandName",product);
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        brand.setId(id);
        assertEquals(id, brand.getId());
    }

    @Test
    public void testSetAndGetProduct() {
        Product newProduct = new Product();
        newProduct.setId(2L);
        newProduct.setTitle("New Product");
        newProduct.setPrice(200.0);
        newProduct.setStock(20);
        newProduct.setPicture("new.jpg");

        brand.setProduct(newProduct);
        assertEquals(newProduct, brand.getProduct());
    }

    @Test
    public void testSetAndGetName() {
        String name = "NewBrandName";
        brand.setName(name);
        assertEquals(name, brand.getName());
    }

    @Test
    public void testBrandInitialization() {
        assertEquals(product, brand.getProduct());
        assertEquals("BrandName", brand.getName());
        assertNull(brand.getId());
    }

    @Test
    public void testConstructor() {
        Brand newBrand = new Brand("AnotherBrandName",product);
        assertEquals(product, newBrand.getProduct());
        assertEquals("AnotherBrandName", newBrand.getName());
    }
}