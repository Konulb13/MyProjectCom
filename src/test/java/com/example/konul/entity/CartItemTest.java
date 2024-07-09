package com.example.konul.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartItemTest {
    @Mock
    private Product product;

    @InjectMocks
    private CartItem cartItem;

    @BeforeEach
    public void setup() {
        cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(2);
        cartItem.setSize("M");
    }

    @Test
    public void testCanUpdateQuantity() {
        when(product.hasStock(anyInt())).thenReturn(true);
        assertTrue(cartItem.canUpdateQuantity(5));

        when(product.hasStock(anyInt())).thenReturn(false);
        assertFalse(cartItem.canUpdateQuantity(5));

        assertTrue(cartItem.canUpdateQuantity(null));
    }

    @Test
    public void testGetSubtotal() {
        when(product.getPrice()).thenReturn(20.0);
        cartItem.setQuantity(2);
        assertEquals(BigDecimal.valueOf(40.0), cartItem.getSubtotal());
    }

    @Test
    public void testAddQuantity() {
        cartItem.addQuantity(3);
        assertEquals(5, cartItem.getQuantity());

        cartItem.addQuantity(-1);
        assertEquals(5, cartItem.getQuantity());
    }

    @Test
    public void testHasSameSizeThan() {
        assertTrue(cartItem.hasSameSizeThan("M"));
        assertFalse(cartItem.hasSameSizeThan("L"));
    }
}
