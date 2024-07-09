package com.example.konul.service;

import com.example.konul.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;


import java.util.List;

public interface OrderService {
//    @Transactional
//    @CacheEvict(value="item_count",allEntries=true)
    Order createOrder(ShoppingCart shoppingCart, Shipping shippingAddress, Payment payment, User user);

    List<Order> findByUser(User user);

    Order findOrderWithDetails(Long id);}
