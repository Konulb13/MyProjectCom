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
    String card_name;
    @NonNull
    private String card_number;
    @NonNull
    private int expiry_month;
    @NonNull
    private int expiry_year;
    @NonNull
    private int cvc;

    @NonNull
    private String holder_name;

    @OneToOne
    @NonNull
    private Order order;
}