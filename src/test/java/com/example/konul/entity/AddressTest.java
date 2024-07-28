//package com.example.konul.entity;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AddressTest {
//
//    private Address address;
//
//    @BeforeEach
//    public void setUp() {
//        address = new Address();
//    }
//
//    @Test
//    public void testSetAndGetId() {
//        Long id = 1L;
//        address.setId(id);
//        assertEquals(id, address.getId());
//    }
//
//    @Test
//    public void testSetAndGetCountry() {
//        String country = "Slovakia";
//        address.setCountry(country);
//        assertEquals(country, address.getCountry());
//    }
//
//    @Test
//    public void testSetAndGetCity() {
//        String city = "Bratislava";
//        address.setCity(city);
//        assertEquals(city, address.getCity());
//    }
//
//    @Test
//    public void testSetAndGetStreet() {
//        String street = "Main St";
//        address.setStreet(street);
//        assertEquals(street, address.getStreet());
//    }
//
//    @Test
//    public void testSetAndGetZipCode() {
//        String zipCode = "10001";
//        address.setZipCode(zipCode);
//        assertEquals(zipCode, address.getZipCode());
//    }
//
//    @Test
//    public void testAddressInitialization() {
//        Address newAddress = new Address();
//        newAddress.setCountry("Slovakia");
//        newAddress.setCity("Bratislava");
//        newAddress.setStreet("Main St");
//        newAddress.setZipCode("10001");
//
//        assertNull(newAddress.getId());
//        assertEquals("Slovakia", newAddress.getCountry());
//        assertEquals("Bratislava", newAddress.getCity());
//        assertEquals("Main St", newAddress.getStreet());
//        assertEquals("10001", newAddress.getZipCode());
//    }
//}