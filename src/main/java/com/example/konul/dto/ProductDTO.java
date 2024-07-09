package com.example.konul.dto;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDTO {
    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private double price;
    @NonNull
    private String picture;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
}
