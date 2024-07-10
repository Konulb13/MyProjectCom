package com.example.konul.repository;

import com.example.konul.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository  extends CrudRepository<User, Long> {
    @EntityGraph(value = "UserComplete", type= EntityGraph.EntityGraphType.FETCH)
    User findByUsername(String userName);

    User findByEmail(String email);
}
