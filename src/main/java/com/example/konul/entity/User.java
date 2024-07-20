package com.example.konul.entity;

import com.example.konul.entity.security.Authority;
import com.example.konul.entity.security.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString

@NamedEntityGraph(
        name= "UserComplete",
        attributeNodes= { @NamedAttributeNode(value="userRoles", subgraph="role-subgraph") },
        subgraphs= {
                @NamedSubgraph(name = "role-subgraph", attributeNodes = {  @NamedAttributeNode("role") }
                )})

@Entity
@SuppressWarnings("serial")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false,updatable = false)
    @NonNull
    private Long id;

    @NonNull
    private String userName;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String password;

    @Email
    @NotNull
    private String email;

    @OneToOne(cascade= CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="address_id")
    @NonNull
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @NonNull
    private Set<UserRole> userRoles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorites = new HashSet<>();
        userRoles.forEach(userRole -> authorites.add(new Authority(userRole.getRole().getName())));
        return authorites;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }}


//          //Lombok - no need to write
//    public Address getAddress() {
//        return address;
//    }
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//
//
//    public Set<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(Set<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }

