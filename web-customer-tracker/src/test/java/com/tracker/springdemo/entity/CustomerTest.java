package com.tracker.springdemo.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @Test
    void getId() {
        int expected = 0;

        assertEquals(expected, customer.getId());
    }

    @Test
    void setId() {
        customer.setId(23);
        int expected = 23;

        assertEquals(expected, customer.getId());
    }

    @Test
    void getFirstName() {
        assertEquals(null, customer.getFirstName());
    }

    @Test
    void setFirstName() {
        customer.setFirstName("Anita");
        String expected = "Anita";

        assertEquals(expected, customer.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(null, customer.getLastName());
    }

    @Test
    void setLastName() {
        customer.setLastName("Bath");
        String expected = "Bath";

        assertEquals(expected, customer.getLastName());
    }

    @Test
    void getEmail() {
        assertEquals(null, customer.getEmail());
    }

    @Test
    void setEmail() {
        customer.setEmail("anita.bath@right.now");
        String expected = "anita.bath@right.now";

        assertEquals(expected, customer.getEmail());
    }

    @Test
    void testToString() {
        customer.setId(23);
        customer.setFirstName("Phil");
        customer.setLastName("Mycrackin");
        customer.setEmail("phil@mycrackin.io");

        String expected = "Customer{" +
                "id=" + customer.getId() +
                ", firstName='" + customer.getFirstName() + '\'' +
                ", lastName='" + customer.getLastName() + '\'' +
                ", email='" + customer.getEmail() + '\'' +
                '}';

        assertEquals(expected, customer.toString());
    }
}