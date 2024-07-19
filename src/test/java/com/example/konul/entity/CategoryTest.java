package com.example.konul.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {
    @Mock
    private Product product;

    private Category category;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        category = new Category("Test Category",product);
    }

    @Test
    public void testConstructor() {
        assertNotNull(category);
        assertEquals(product, category.getProduct());
        assertEquals("Test Category", category.getName());
    }

    @Test
    public void testSettersAndGetters() {
        category.setId(1L);
        assertEquals(1L, category.getId());

        Product newProduct = new Product();
        category.setProduct(newProduct);
        assertEquals(newProduct, category.getProduct());

        category.setName("New Category");
        assertEquals("New Category", category.getName());
    }
}
