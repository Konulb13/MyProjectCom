package com.example.konul.entity.security;

import com.example.konul.entity.User;
import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @NonNull
    private Role role;


    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}

    //    public UserRole() {
//
//    }
//
//    public UserRole(User user, Role role) {
//        this.user = user;
//        this.role = role;
//    }
//
//    public Long getUserRoleId() {
//        return userRoleId;
//    }
//
//    public void setUserRoleId(Long userRoleId) {
//        this.userRoleId = userRoleId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }