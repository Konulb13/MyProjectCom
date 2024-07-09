package com.example.konul.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private double price;
    @NonNull
    private int stock;
    @NonNull
    private String picture;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    @NonNull
    private Set<Size>sizes;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    @NonNull
    private Set<Brand>brands;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    @NonNull
    private Set<Category>categories;


public boolean hasStock(int amount){
    return (this.getStock()>0)&&(amount<= this.getStock());}

    public void decreaseStock(int amount) { this.stock=this.stock-amount; }
//
//    public Product(Long id, String title, double price, int stock, String picture, Set<Size> sizes, Set<Brand> brands, Set<Category> categories) {
//        this.id = id;
//        this.title = title;
//        this.price = price;
//        this.stock = stock;
//        this.picture = picture;
//        this.sizes = sizes;
//        this.brands = brands;
//        this.categories = categories;
//    }
    //set-get

//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public int getStock() {
//        return stock;
//    }
//    public void setStock(int stock) {
//        this.stock = stock;
//    }
//
//    public String getPicture() {
//        return picture;
//    }
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
//    public Set<Size>getSizes(){return sizes;}
//    public void setSizes(Set<Size> sizes){
//        this.sizes = sizes;}
//
//    public Set<Brand>getBrands(){
//        return brands;
//    }
//    public void setBrands(Set<Brand>brands) {
//        this.brands = brands;
//    }
//
//    public  Set<Category>getCategories(){
//        return categories;
//    }
//    public void setCategories(Set<Category> categories) {
//        this.categories =categories;
//    }

    public void addSize(Size size) {
        sizes.add(size);
        size.setProduct(this);
    }

    public void removeSize(Size size) {
        sizes.remove(size);
        size.setProduct(null);
    }                        // butun productlar silinmesin deye size = null

    public void addCategory(Category category) {
        categories.add(category);
        category.setProduct(this);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
        category.setProduct(null);
    }

    public void addBrand(Brand brand) {
        brands.add(brand);
        brand.setProduct(this);
    }

    public void removeBrand(Brand brand) {
        brands.remove(brand);
        brand.setProduct(null);
    }

}