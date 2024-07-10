package com.example.konul.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="user_order")
public class Order {   //vse
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long id;
    @NonNull
    private Date orderDate;
    @NonNull
    private Date shippingDate;
    @NonNull
    private String orderStatus;
    @NonNull
    private BigDecimal orderTotal;

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @NonNull
    private List<CartItem> cartItems;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @NonNull
    private Shipping shipping;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @NonNull
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private User user;

}
