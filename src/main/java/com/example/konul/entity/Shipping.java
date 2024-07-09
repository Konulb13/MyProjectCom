package com.example.konul.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String receiver;   // booker

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name= "address_id")
    @NonNull
    private Address address;

    @OneToOne
    @NonNull
    private Order order;
}
