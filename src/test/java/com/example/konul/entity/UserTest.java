//package com.example.konul.entity;
//
//import com.example.konul.entity.security.Authority;
//import com.example.konul.entity.security.Role;
//import com.example.konul.entity.security.UserRole;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.core.GrantedAuthority;
//import jakarta.validation.constraints.Email;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class UserTest {
//
//    private User user;
//
//    @Mock
//    private Address address;
//
//    @Mock
//    private UserRole userRole;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        Set<UserRole> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user = new User(1L, "username", "firstname", "lastname", "password", "email@example.com", address, userRoles);
//    }
//
//    @Test
//    public void testConstructor() {
//        assertNotNull(user);
//        assertEquals(1L, user.getId());
//        assertEquals("username", user.getUsername());
//        assertEquals("firstname", user.getFirstName());
//        assertEquals("lastname", user.getLastName());
//        assertEquals("password", user.getPassword());
//        assertEquals("email@example.com", user.getEmail());
//        assertEquals(address, user.getAddress());
//        assertEquals(1, user.getUserRoles().size());
//        assertTrue(user.getUserRoles().contains(userRole));
//    }
//
//    @Test
//    public void testSettersAndGetters() {
//        user.setId(2L);
//        assertEquals(2L, user.getId());
//
//        user.setUserName("newusername");
//        assertEquals("newusername", user.getUsername());
//
//        user.setFirstName("newfirstname");
//        assertEquals("newfirstname", user.getFirstName());
//
//        user.setLastName("newlastname");
//        assertEquals("newlastname", user.getLastName());
//
//        user.setPassword("newpassword");
//        assertEquals("newpassword", user.getPassword());
//
//        user.setEmail("newemail@example.com");
//        assertEquals("newemail@example.com", user.getEmail());
//
//        Address newAddress = new Address();
//        user.setAddress(newAddress);
//        assertEquals(newAddress, user.getAddress());
//
//        Set<UserRole> newUserRoles = new HashSet<>();
//        user.setUserRoles(newUserRoles);
//        assertEquals(newUserRoles, user.getUserRoles());
//    }
//
//    @Test
//    public void testGetAuthorities() {
//        Role role = new Role(1L, "ROLE_USER", new HashSet<>());
//        when(userRole.getRole()).thenReturn(role);
//        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
//        assertEquals(1, authorities.size());
//        assertTrue(authorities.contains(new Authority("ROLE_USER")));
//    }
//
//    @Test
//    public void testIsAccountNonExpired() {
//        assertTrue(user.isAccountNonExpired());
//    }
//
//    @Test
//    public void testIsAccountNonLocked() {
//        assertTrue(user.isAccountNonLocked());
//    }
//
//    @Test
//    public void testIsCredentialsNonExpired() {
//        assertTrue(user.isCredentialsNonExpired());
//    }
//
//    @Test
//    public void testIsEnabled() {
//        assertTrue(user.isEnabled());
//    }
//}