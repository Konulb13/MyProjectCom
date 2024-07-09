package com.example.konul.service;
import com.example.konul.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);

    User findByEmail(String email);
     void save(User user);
     User createUser(String user_name, String email, String password, List<String> roles);
}
