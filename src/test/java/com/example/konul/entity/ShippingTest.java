package com.example.konul.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShippingTest {

    @InjectMocks
    private Shipping shipping;

    @Mock
    private Address address;

    @Mock
    private Order order;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        shipping = new Shipping(1L, "John Doe", address, order);
    }

    @Test
    public void testShippingCreation() {
        assertNotNull(shipping);
        assertEquals(1L, shipping.getId());
        assertEquals("John Doe", shipping.getReceiver());
        assertEquals(address, shipping.getAddress());
        assertEquals(order, shipping.getOrder());
    }

    @Test
    public void testSettersAndGetters() {
        shipping.setId(2L);
        shipping.setReceiver("Jane Smith");

        assertEquals(2L, shipping.getId());
        assertEquals("Jane Smith", shipping.getReceiver());
    }

    @Test
    public void testAddress() {
        assertEquals(address, shipping.getAddress());
        Address newAddress = new Address();  // assume this is your Address class
        shipping.setAddress(newAddress);
        assertEquals(newAddress, shipping.getAddress());
    }

    @Test
    public void testOrder() {
        assertEquals(order, shipping.getOrder());
        Order newOrder = new Order();  // assume this is your Order class
        shipping.setOrder(newOrder);
        assertEquals(newOrder, shipping.getOrder());
    }
}
