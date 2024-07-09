package com.example.konul.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductBuilder {
    private String title;
    private int stock;
    private double price;
    private String picture;
    private List<String> sizes;
    private List<String> categories;
    private List<String> brands;

    public ProductBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProductBuilder stockAvailable(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder imageLink(String picture) {
        this.picture = picture;
        return this;
    }

    public ProductBuilder sizesAvailable(List<String> sizes) {
        this.sizes = sizes;
        return this;
    }

    public ProductBuilder ofCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public ProductBuilder ofBrand(List<String> brands) {
        this.brands = brands;
        return this;
    }


    public Product build() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setStock(this.stock);
        product.setPicture(this.picture);

        if (this.sizes != null && !this.sizes.isEmpty()) {
            Set<Size> sizeElements = new HashSet<>();
            for (String value: this.sizes) {
                sizeElements.add(new Size(value,product));
            }
            product.setSizes(sizeElements);
        }

        if (this.categories != null && !this.categories.isEmpty()) {
            Set<Category> categoryElements = new HashSet<>();
            for (String value: this.categories) {
                categoryElements.add(new Category(product,value));
            }
            product.setCategories(categoryElements);
        }
        if (this.brands != null && !this.brands.isEmpty()) {
            Set<Brand> brandElements = new HashSet<>();
            for (String value : this.brands) {
                brandElements.add(new Brand(product,value));
            }
            product.setBrands(brandElements);
        }
        return product;
    }
}