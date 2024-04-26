package com.example.autocamper_project.Model;

import javafx.scene.control.DatePicker;

import java.util.Date;

public class Customer {
    private int customerID;
    private String name;
    private String eMail;
    private String phoneNumber;
    private String street;
    private String city;
    private String zipcode;
    private String countryCode;
    private int amountRentals;

    /**
     * Constructor for a customer object
     * @param name of customer
     * @param eMail of customer
     * @param phoneNumber of customer
     * @param street of customer
     * @param city of customer
     * @param zipcode of customer
     * @param countryCode of customer
     */
    public Customer(String name, String eMail, String phoneNumber, String street, String city, String zipcode, String countryCode) {
        this.name = name;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.countryCode = countryCode;
    }

    /**
     * Constructor of customer object
     * @param customerID of customer record in database
     * @param name of customer
     * @param eMail of customer
     * @param phoneNumber of customer
     * @param street of customer
     * @param city of customer
     * @param zipcode of customer
     * @param countryCode of customer
     * @param amountRentals of customer
     */
    public Customer(int customerID, String name, String eMail, String phoneNumber, String street, String city, String zipcode, String countryCode, int amountRentals) {
        this.customerID = customerID;
        this.name = name;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.countryCode = countryCode;
        this.amountRentals = amountRentals;
    }

    public int getCustomerID() {
        return customerID;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return eMail;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getZipcode() {
        return zipcode;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public int getAmountRentals() {
        return amountRentals;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String eMail) {
        this.eMail = eMail;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public void setAmountRentals(int amountRentals) {
        this.amountRentals = amountRentals;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
