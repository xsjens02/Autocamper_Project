package com.example.autocamper_project.Controller;

import com.example.autocamper_project.Model.Customer;
import com.example.autocamper_project.Persistence.CustomerDAO_impl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class bookingPageControllerTest {

    private final CustomerDAO_impl customerDAO = new CustomerDAO_impl();
    bookingPageController testController = new bookingPageController();

    @Test
    void calculateDiscount() {
        Customer customer = customerDAO.read(3);
        int expected = 10;
        int actual = testController.calculateDiscount(customer.getAmountRentals());
        assertEquals(expected, actual);
    }

    @Test
    void isInteger() {
        boolean expected = true;
        boolean actual = testController.isInteger("1");
        assertEquals(expected, actual);
    }
}