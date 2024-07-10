package com.example.konul.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    private Payment payment;
    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
        order.setId(1L);
        order.setOrderDate(new Date());
        order.setShippingDate(new Date());
        order.setOrderStatus("Pending");
        order.setOrderTotal(BigDecimal.valueOf(100.00));

        payment = new Payment();
        payment.setId(1L);
        payment.setType("Credit Card");
        payment.setCardName("Visa");
        payment.setCardNumber("1234567812345678");
        payment.setExpiryMonth(12);
        payment.setExpiryYear(2025);
        payment.setCvc(123);
        payment.setHolderName("Konul Bairamova");
        payment.setOrder(order);
    }

    @Test
    public void testSetAndGetId() {
        Long id = 2L;
        payment.setId(id);
        assertEquals(id, payment.getId());
    }

    @Test
    public void testSetAndGetType() {
        String type = "Debit Card";
        payment.setType(type);
        assertEquals(type, payment.getType());
    }

    @Test
    public void testSetAndGetCardName() {
        String cardName = "MasterCard";
        payment.setCardName(cardName);
        assertEquals(cardName, payment.getCardName());
    }

    @Test
    public void testSetAndGetCardNumber() {
        String cardNumber = "8765432187654321";
        payment.setCardNumber(cardNumber);
        assertEquals(cardNumber, payment.getCardNumber());
    }

    @Test
    public void testSetAndGetExpiryMonth() {
        int month = 11;
        payment.setExpiryMonth(month);
        assertEquals(month, payment.getExpiryMonth());
    }

    @Test
    public void testSetAndGetExpiryYear() {
        int year = 2024;
        payment.setExpiryYear(year);
        assertEquals(year, payment.getExpiryYear());
    }

    @Test
    public void testSetAndGetCvc() {
        int cvc = 456;
        payment.setCvc(cvc);
        assertEquals(cvc, payment.getCvc());
    }

    @Test
    public void testSetAndGetHolderName() {
        String holderName = "Konul Bairamova";
        payment.setHolderName(holderName);
        assertEquals(holderName, payment.getHolderName());
    }

    @Test
    public void testSetAndGetOrder() {
        Order newOrder = new Order();
        newOrder.setId(2L);
        payment.setOrder(newOrder);
        assertEquals(newOrder, payment.getOrder());
    }

    @Test
    public void testPaymentInitialization() {
        assertEquals(1L, payment.getId());
        assertEquals("Credit Card", payment.getType());
        assertEquals("Visa", payment.getCardName());
        assertEquals("1234567812345678", payment.getCardNumber());
        assertEquals(12, payment.getExpiryMonth());
        assertEquals(2025, payment.getExpiryYear());
        assertEquals(123, payment.getCvc());
        assertEquals("Konul Bairamova", payment.getHolderName());
        assertEquals(order, payment.getOrder());
    }
}