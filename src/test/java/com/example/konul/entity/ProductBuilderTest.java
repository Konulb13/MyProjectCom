package com.example.konul.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ProductBuilderTest {

    @Test
    public void testBuildProduct() {
        List<String> sizes = Arrays.asList("S", "M", "L");
        List<String> categories = Arrays.asList("Clothing", "Men");
        List<String> brands = Arrays.asList("BrandA", "BrandB");

        Product product = new ProductBuilder()
                .withTitle("T-Shirt")
                .stockAvailable(100)
                .withPrice(29.99)
                .imageLink("http://example.com/image.jpg")
                .sizesAvailable(sizes)
                .ofCategories(categories)
                .ofBrand(brands)
                .build();

        assertNotNull(product);
        assertEquals("T-Shirt", product.getTitle());
        assertEquals(100, product.getStock());
        assertEquals(29.99, product.getPrice());
        assertEquals("http://example.com/image.jpg", product.getPicture());

        Set<String> sizeValues = new HashSet<>();
        product.getSizes().forEach(size -> sizeValues.add(size.getValue()));
        assertTrue(sizeValues.containsAll(sizes));

        Set<String> categoryNames = new HashSet<>();
        product.getCategories().forEach(category -> categoryNames.add(category.getName()));
        assertTrue(categoryNames.containsAll(categories));

        Set<String> brandNames = new HashSet<>();
        product.getBrands().forEach(brand -> brandNames.add(brand.getName()));
        assertTrue(brandNames.containsAll(brands));
    }

    @Test
    public void testBuildProductWithoutOptionalFields() {
        Product product = new ProductBuilder()
                .withTitle("T-Shirt")
                .stockAvailable(100)
                .withPrice(29.99)
                .imageLink("http://example.com/image.jpg")
                .build();

        assertNotNull(product);
        assertEquals("T-Shirt", product.getTitle());
        assertEquals(100, product.getStock());
        assertEquals(29.99, product.getPrice());
        assertEquals("http://example.com/image.jpg", product.getPicture());
        assertNull(product.getSizes());
        assertNull(product.getCategories());
        assertNull(product.getBrands());
    }
}