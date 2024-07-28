//package com.example.konul.entity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//public class OrderTest {
//    private Order order;
//
//    @Mock
//    private User user;
//
//    @Mock
//    private Shipping shipping;
//
//    @Mock
//    private Payment payment;
//
//    @Mock
//    private CartItem cartItem;
//
//    private List<CartItem> cartItemList;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        cartItemList = new ArrayList<>();
//        cartItemList.add(cartItem);
//        order = new Order(1L, new Date(), new Date(), "Pending", BigDecimal.valueOf(100.0), cartItemList, shipping, payment, user);
//    }
//
//    @Test
//    public void testConstructor() {
//        assertNotNull(order);
//        assertEquals(1L, order.getId());
//        assertEquals("Pending", order.getOrderStatus());
//        assertEquals(BigDecimal.valueOf(100.0), order.getOrderTotal());
//        assertEquals(cartItemList, order.getCartItems());
//        assertEquals(shipping, order.getShipping());
//        assertEquals(payment, order.getPayment());
//        assertEquals(user, order.getUser());
//    }
//
//    @Test
//    public void testSettersAndGetters() {
//        order.setId(2L);
//        assertEquals(2L, order.getId());
//
//        Date newOrderDate = new Date();
//        order.setOrderDate(newOrderDate);
//        assertEquals(newOrderDate, order.getOrderDate());
//
//        Date newShippingDate = new Date();
//        order.setShippingDate(newShippingDate);
//        assertEquals(newShippingDate, order.getShippingDate());
//
//        order.setOrderStatus("Shipped");
//        assertEquals("Shipped", order.getOrderStatus());
//
//        order.setOrderTotal(BigDecimal.valueOf(200.0));
//        assertEquals(BigDecimal.valueOf(200.0), order.getOrderTotal());
//
//        List<CartItem> newCartItems = new ArrayList<>();
//        order.setCartItems(newCartItems);
//        assertEquals(newCartItems, order.getCartItems());
//
//        Shipping newShipping = new Shipping();
//        order.setShipping(newShipping);
//        assertEquals(newShipping, order.getShipping());
//
//        Payment newPayment = new Payment();
//        order.setPayment(newPayment);
//        assertEquals(newPayment, order.getPayment());
//
//        User newUser = new User();
//        order.setUser(newUser);
//        assertEquals(newUser, order.getUser());
//    }
//}
