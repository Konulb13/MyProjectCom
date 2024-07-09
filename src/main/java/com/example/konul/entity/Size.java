package com.example.konul.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Size implements Comparable<Size> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    @NonNull
    private Product product;
    @NonNull
    private String value;

    public Size(String value, Product product) {
        this.value = value;
        this.product = product;
    }

    @Override
    public int compareTo(Size s){
        return this.value.compareTo(s.getValue());
    }
}
