package com.example.konul.service.Impl;

import com.example.konul.entity.User;
import com.example.konul.entity.security.Role;
import com.example.konul.entity.security.UserRole;
import com.example.konul.repository.RoleRepository;
import com.example.konul.repository.UserRepository;
import com.example.konul.service.UserService;
import lombok.extern.slf4j.Slf4j;
import util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findById(Long id) {
//        log.info("ID " + id);
        Optional<User> opt = userRepository.findById(id);
        log.info("methodu cagirdim");
        return opt.get();
    }

    @Override
    public User findByUserName(String userName) {
        log.info("Searching for username: {}",userName);
        return userRepository.findByUserName(userName);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {

        userRepository.save(user);
    }

    @Override
    @Transactional
    public User createUser(String userName, String password, String email, List<String> roles) {
        User user = findByUserName(userName);
        if (user != null) {
            return user;
        } else {
            log.info("user is null");
            user = new User();
            user.setUserName(userName);
//            log.info("username set eledim: " + user.getuserName() );
            user.setPassword(SecurityUtil.passwordEncoder().encode(password));
            user.setEmail(email);
//            log.info("email set eledim: " + user.getEmail() );
            Set<UserRole> userRoles = new HashSet<>();
            for (String roleName : roles) {
                Role role = roleRepository.findByName(roleName);
                if (role == null) {
                    role = new Role();
                    role.setName(roleName);
                    roleRepository.save(role);
                }
                userRoles.add(new UserRole(user,role));
            }
            user.setUserRoles(userRoles);
            return userRepository.save(user);
        }
    }
}
