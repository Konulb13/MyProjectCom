package com.example.konul.service.Impl;
import com.example.konul.entity.User;
import com.example.konul.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
     //   User user = userRepository.findFirstByUserName(userName);
        User user = userRepository.findByUserName(userName);
        log.info("### received username {}",userName);


        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        log.info("### user email {}",user.getEmail());
        log.info("### user password {}",user.getPassword());

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(),
                user.getAuthorities());
        log.info("Authentication.getName: {}", authentication.getName());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return user;
    }

    public void authenticateUser(String userName) {
        UserDetails userDetails = loadUserByUsername(userName);
        log.info("UserDetails: {}", userDetails);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
                userDetails.getAuthorities());
        log.info("Authentication.getName: {}", authentication.getName());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
