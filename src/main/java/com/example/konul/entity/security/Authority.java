package com.example.konul.entity.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@AllArgsConstructor
@SuppressWarnings("serial")
public class Authority  implements GrantedAuthority {

    private final String authority;

//    public Authority(String authority) {
//        this.authority = authority;
//    }

    public String getAuthority() {
        return authority;
    }
}
