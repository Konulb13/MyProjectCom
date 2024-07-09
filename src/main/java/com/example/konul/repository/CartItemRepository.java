package com.example.konul.repository;

import com.example.konul.entity.CartItem;
import com.example.konul.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CartItemRepository  extends CrudRepository<CartItem, Long> {
    @EntityGraph(attributePaths = {"product"})
    List<CartItem>findAllByUserAndOrderIsNull(User user);
    void deleteAllByUserAndOrderIsNull(User user);
    int countDistinctByUserAndOrderIsNull(User user);
}
