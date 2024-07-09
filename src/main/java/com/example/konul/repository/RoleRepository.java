package com.example.konul.repository;

import com.example.konul.entity.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
    //for security
}