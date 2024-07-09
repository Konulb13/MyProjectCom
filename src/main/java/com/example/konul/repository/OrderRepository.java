package com.example.konul.repository;

import com.example.konul.entity.Order;
import com.example.konul.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OrderRepository  extends CrudRepository<Order, Long> {
    List<Order> findByUser(User user);

    @EntityGraph(attributePaths =  { "cartItems", "payment", "shipping"})
    Order findEagerById(long id);
}
