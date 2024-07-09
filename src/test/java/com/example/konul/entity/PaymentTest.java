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
        order.setOrder_date(new Date());
        order.setShipping_date(new Date());
        order.setOrder_status("Pending");
        order.setOrder_total(BigDecimal.valueOf(100.00));

        payment = new Payment();
        payment.setId(1L);
        payment.setType("Credit Card");
        payment.setCard_name("Visa");
        payment.setCard_number("1234567812345678");
        payment.setExpiry_month(12);
        payment.setExpiry_year(2025);
        payment.setCvc(123);
        payment.setHolder_name("John Doe");
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
        payment.setCard_name(cardName);
        assertEquals(cardName, payment.getCard_name());
    }

    @Test
    public void testSetAndGetCardNumber() {
        String cardNumber = "8765432187654321";
        payment.setCard_number(cardNumber);
        assertEquals(cardNumber, payment.getCard_number());
    }

    @Test
    public void testSetAndGetExpiryMonth() {
        int month = 11;
        payment.setExpiry_month(month);
        assertEquals(month, payment.getExpiry_month());
    }

    @Test
    public void testSetAndGetExpiryYear() {
        int year = 2024;
        payment.setExpiry_year(year);
        assertEquals(year, payment.getExpiry_year());
    }

    @Test
    public void testSetAndGetCvc() {
        int cvc = 456;
        payment.setCvc(cvc);
        assertEquals(cvc, payment.getCvc());
    }

    @Test
    public void testSetAndGetHolderName() {
        String holderName = "Jane Doe";
        payment.setHolder_name(holderName);
        assertEquals(holderName, payment.getHolder_name());
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
        assertEquals("Visa", payment.getCard_name());
        assertEquals("1234567812345678", payment.getCard_number());
        assertEquals(12, payment.getExpiry_month());
        assertEquals(2025, payment.getExpiry_year());
        assertEquals(123, payment.getCvc());
        assertEquals("John Doe", payment.getHolder_name());
        assertEquals(order, payment.getOrder());
    }
}