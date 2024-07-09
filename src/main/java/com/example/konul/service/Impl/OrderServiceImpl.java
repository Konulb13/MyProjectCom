package com.example.konul.service.Impl;

import com.example.konul.entity.*;
import com.example.konul.repository.CartItemRepository;
import com.example.konul.repository.OrderRepository;
import com.example.konul.repository.ProductRepository;
import com.example.konul.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;


    @Override
    @Transactional
    @CacheEvict(value="item_count",allEntries=true)
    public synchronized Order createOrder(ShoppingCart shoppingCart, Shipping shipping, Payment payment, User user) {
        Order order = new Order();
        order.setUser(user);
        order.setPayment(payment);
        order.setShipping(shipping);
        order.setOrder_total(shoppingCart.getGrandTotal());
        shipping.setOrder(order);
        payment.setOrder(order);
        LocalDate today = LocalDate.now();
        LocalDate estimatedDeliveryDate = today.plusDays(7);
        order.setOrder_date(Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        order.setShipping_date(Date.from(estimatedDeliveryDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        order.setOrder_status("In Progress");

        order = orderRepository.save(order);
        List<CartItem> cartItems= shoppingCart.getCartItems();
        for(CartItem cartItem : cartItems){
            Product product = cartItem.getProduct();
            product.decreaseStock(cartItem.getQuantity());
            productRepository.save(product);
            cartItemRepository.save(cartItem);
        }
        return order;
    }

    @Override
    public Order findOrderWithDetails(Long id) {
        return orderRepository.findEagerById(id);
    }

    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }

}
