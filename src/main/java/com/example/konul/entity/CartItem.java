package com.example.konul.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@RequiredArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private  Long id;

    @NonNull
    private int quantity;  //int or Integer?

    @NonNull
    private String size;

    @OneToOne
    @JoinColumn(name="product_id")
    @NonNull
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
    @NonNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @NonNull
    private Order order;

    public boolean canUpdateQuantity(Integer quantity) {
        return quantity == null || quantity <= 0 || this.getProduct().hasStock(quantity);
    }
    public BigDecimal getSubtotal(){
        return new BigDecimal(product.getPrice()).multiply(new BigDecimal(quantity));
    }

    public void addQuantity(int quantity){
        if(quantity>0){
            this.quantity = this.quantity + quantity;
        }
    }
    public boolean hasSameSizeThan(String size2) {
        return this.size.equals(size2);
    }
}
