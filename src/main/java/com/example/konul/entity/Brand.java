package com.example.konul.entity;
import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @ManyToOne
    @JoinColumn(name ="product_id")
    @NonNull
    private  Product product;

    @NonNull
    private  String name;

    public Brand(@NonNull Product product, @NonNull String name) {
        this.product = product;
        this.name = name;
    }
}
