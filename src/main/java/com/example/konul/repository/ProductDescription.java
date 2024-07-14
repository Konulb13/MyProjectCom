package com.example.konul.repository;

import com.example.konul.entity.Brand;
import com.example.konul.entity.Category;
import com.example.konul.entity.Product;
import com.example.konul.entity.Size;
import jakarta.persistence.criteria.*;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ProductDescription {

    @SuppressWarnings("serial")
    public static Specification<Product> filterBy(Integer priceLow, Integer priceHigh, List<String> sizes, List<String> categories, List<String> brands, String search) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                query.distinct(true);
                if (sizes != null && !sizes.isEmpty()) {
                    Join<Product, Size> joinSize = root.join("sizes");
                    predicates.add( criteriaBuilder.and(joinSize.get("value").in(sizes)));

                }
                if (categories != null && !categories.isEmpty()) {
                    Join<Product, Category> joinSize = root.join("categories");
                    predicates.add( criteriaBuilder.and(joinSize.get("name").in(categories)));
                }
                if (brands != null && !brands.isEmpty()) {
                    Join<Product, Brand> joinSize = root.join("brands");
                    predicates.add( criteriaBuilder.and(joinSize.get("name").in(brands)));
                }
                if (search != null && !search.isEmpty()) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("title"), "%" + search + "%")));
                }
                if (priceLow != null && priceLow >= 0) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), priceLow)));
                }
                if (priceHigh != null && priceHigh >= 0) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("price"), priceHigh)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
