//package com.example.konul.entity;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class ShoppingCartTest {
//
//    private ShoppingCart shoppingCart;
//    private CartItem cartItem1;
//    private CartItem cartItem2;
//
//    @BeforeEach
//    public void setup() {
//        cartItem1 = mock(CartItem.class);
//        cartItem2 = mock(CartItem.class);
//
//        List<CartItem> cartItems = new ArrayList<>();
//        cartItems.add(cartItem1);
//        cartItems.add(cartItem2);
//
//        shoppingCart = new ShoppingCart(cartItems);
//    }
//
//    @Test
//    public void testGetGrandTotal() {
//        when(cartItem1.getSubtotal()).thenReturn(new BigDecimal("10.00"));
//        when(cartItem2.getSubtotal()).thenReturn(new BigDecimal("20.00"));
//
//        BigDecimal grandTotal = shoppingCart.getGrandTotal();
//        assertEquals(new BigDecimal("30.00"), grandTotal);
//    }
//
//    @Test
//    public void testIsEmpty() {
//        assertFalse(shoppingCart.isEmpty());
//
//        shoppingCart.clearItems();
//        assertTrue(shoppingCart.isEmpty());
//    }
//
//    @Test
//    public void testRemoveCartItem() {
//        when(cartItem1.getId()).thenReturn(1L);
//        when(cartItem2.getId()).thenReturn(2L);
//
//        shoppingCart.removeCartItem(cartItem1);
//        assertEquals(1, shoppingCart.getItemCount());
//        assertFalse(shoppingCart.getCartItems().contains(cartItem1));
//    }
//
//    @Test
//    public void testClearItems() {
//        shoppingCart.clearItems();
//        assertTrue(shoppingCart.isEmpty());
//    }
//
//    @Test
//    public void testFindCartItemByProductAndSize() {
//        Product product1 = mock(Product.class);
//        Product product2 = mock(Product.class);
//
//        when(product1.getId()).thenReturn(1L);
//        when(product2.getId()).thenReturn(2L);
//
//        when(cartItem1.getProduct()).thenReturn(product1);
//        when(cartItem1.getSize()).thenReturn("M");
//        when(cartItem2.getProduct()).thenReturn(product2);
//        when(cartItem2.getSize()).thenReturn("L");
//
//        CartItem foundItem = shoppingCart.findCartItemByProductAndSize(1L, "M");
//        assertNotNull(foundItem);
//        assertEquals(cartItem1, foundItem);
//
//        CartItem notFoundItem = shoppingCart.findCartItemByProductAndSize(3L, "S");
//        assertNull(notFoundItem);
//    }
//
//    @Test
//    public void testGetItemCount() {
//        assertEquals(2, shoppingCart.getItemCount());
//
//        shoppingCart.removeCartItem(cartItem1);
//        assertEquals(1, shoppingCart.getItemCount());
//    }
//}
//
