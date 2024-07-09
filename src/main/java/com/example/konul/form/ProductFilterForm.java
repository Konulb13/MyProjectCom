package com.example.konul.form;
import lombok.*;

import java.util.List;
@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductFilterForm {
    @NonNull
    private List<String> size;
    @NonNull
    private List<String> category;
    @NonNull
    private List<String>brand;
    @NonNull
    private Integer price_low;
    @NonNull
    private Integer price_high;
    @NonNull
    private String sort;
    @NonNull
    private Integer page;
    @NonNull
    private String search;

//    public ProductFilterForm() {
//    }
//
//
//    public List<String> getSize() {
//        return size;
//    }
//
//    public void setSize(List<String> size) {
//        this.size = size;
//    }
//
//
//    public List<String> getCategory() {
//        return category;
//    }
//
//    public void setCategory(List<String> category) {
//        this.category = category;
//    }
//
//
//    public List<String> getBrand() {
//        return brand;
//    }
//
//    public void setBrand(List<String> brand) {
//        this.brand = brand;
//    }
//
//
//    public Integer getPricelow() {
//        return price_low;
//    }
//
//    public void setPricelow(Integer pricelow) {
//        this.price_low = pricelow;
//    }
//
//
//    public Integer getPricehigh() {
//        return price_high;
//    }
//
//    public void setPricehigh(Integer pricehigh) {
//        this.price_high = pricehigh;
//    }
//
//
//    public String getSort() {
//        return sort;
//    }
//
//    public void setSort(String sort) {
//        this.sort = sort;
//    }
//
//
//    public Integer getPage() {
//        return page;
//    }
//
//    public void setPage(Integer page) {
//        this.page = page;
//    }
//
//
//    public String getSearch() {
//        return search;
//    }
//
//    public void setSearch(String search) {
//        this.search = search;
//    }

}
