//package com.example.konul.entity;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SizeTest {
//
//    private Size size;
//    private Product product;
//
//    @BeforeEach
//    public void setUp() {
//        product = new Product();
//        product.setId(1L);
//        product.setTitle("Product A");
//
//        size = new Size();
//        size.setId(1L);
//        size.setValue("M");
//        size.setProduct(product);
//    }
//
//    @Test
//    public void testSetAndGetId() {
//        Long id = 2L;
//        size.setId(id);
//        assertEquals(id, size.getId());
//    }
//
//    @Test
//    public void testSetAndGetValue() {
//        String value = "L";
//        size.setValue(value);
//        assertEquals(value, size.getValue());
//    }
//
//    @Test
//    public void testSetAndGetProduct() {
//        Product newProduct = new Product();
//        newProduct.setId(2L);
//        newProduct.setTitle("Product B");
//        size.setProduct(newProduct);
//        assertEquals(newProduct, size.getProduct());
//    }
//
//    @Test
//    public void testSizeInitialization() {
//        assertEquals(1L, size.getId());
//        assertEquals("M", size.getValue());
//        assertEquals(product, size.getProduct());
//    }
//
//    @Test
//    public void testCompareTo() {
//        Size smallerSize = new Size();
//        smallerSize.setValue("S");
//
//        Size largerSize = new Size();
//        largerSize.setValue("XL");
//
//        assertTrue(size.compareTo(smallerSize) > 0);
//        assertTrue(size.compareTo(size) == 0);
//        assertTrue(size.compareTo(largerSize) < 0);
//    }
//}