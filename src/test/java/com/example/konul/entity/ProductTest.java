//package com.example.konul.entity;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.HashSet;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ProductTest {
//
//    private Product product;
//
//    @Mock
//    private Size size;
//
//    @Mock
//    private Brand brand;
//
//    @Mock
//    private Category category;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        product = new Product(1L, "Test Product", 100.0, 10, "picture.jpg", new HashSet<>(), new HashSet<>(), new HashSet<>());
//    }
//
//    @Test
//    public void testAddSize() {
//        product.addSize(size);
//        assertTrue(product.getSizes().contains(size));
//        assertEquals(product, size.getProduct());
//    }
//
//    @Test
//    public void testRemoveSize() {
//        product.addSize(size);
//        product.removeSize(size);
//        assertFalse(product.getSizes().contains(size));
//        assertNull(size.getProduct());
//    }
//
//    @Test
//    public void testAddCategory() {
//        product.addCategory(category);
//        assertTrue(product.getCategories().contains(category));
//        assertEquals(product, category.getProduct());
//    }
//
//    @Test
//    public void testRemoveCategory() {
//        product.addCategory(category);
//        product.removeCategory(category);
//        assertFalse(product.getCategories().contains(category));
//        assertNull(category.getProduct());
//    }
//
//    @Test
//    public void testAddBrand() {
//        product.addBrand(brand);
//        assertTrue(product.getBrands().contains(brand));
//        assertEquals(product, brand.getProduct());
//    }
//
//    @Test
//    public void testRemoveBrand() {
//        product.addBrand(brand);
//        product.removeBrand(brand);
//        assertFalse(product.getBrands().contains(brand));
//        assertNull(brand.getProduct());
//    }
//
//    @Test
//    public void testHasStock() {
//        assertTrue(product.hasStock(5));
//        assertFalse(product.hasStock(15));
//        product.setStock(0);
//        assertFalse(product.hasStock(1));
//    }
//
//    @Test
//    public void testDecreaseStock() {
//        product.decreaseStock(3);
//        assertEquals(7, product.getStock());
//    }
//}
