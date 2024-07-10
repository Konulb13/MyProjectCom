package com.example.konul.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String type;
    @NonNull
    private
    String cardName;
    @NonNull
    private String cardNumber;
    @NonNull
    private int expiryMonth;
    @NonNull
    private int expiryYear;
    @NonNull
    private int cvc;

    @NonNull
    private String  holderName;

    @OneToOne
    @NonNull
    private Order order;
}