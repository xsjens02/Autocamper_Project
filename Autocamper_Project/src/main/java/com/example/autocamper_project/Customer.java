package com.example.autocamper_project;

import javafx.scene.control.DatePicker;

import java.util.Date;

public class Customer {
    private String fullName;
    private String CustomerID;
    private String eMail;
    private String phoneNumber;
    private String street;
    private String city;
    private String zipcode;
    private String countryCode;
    private int amountRentals;
    private String license;
    private DatePicker licenseIssueDate;

    public Customer(String phoneNumber, String fullName, String eMail, String street, String zipcode, String city, String countryCode, String license, DatePicker licenseIssueDate){
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.eMail = eMail;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.countryCode = countryCode;
        this.license = license;
        this.licenseIssueDate = licenseIssueDate;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getAmountRentals() {
        return amountRentals;
    }

    public void setAmountRentals(int amountRentals) {
        this.amountRentals = amountRentals;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public DatePicker getLicenseIssueDate() {
        return licenseIssueDate;
    }

    public void setLicenseIssueDate(DatePicker licenseIssueDate) {
        this.licenseIssueDate = licenseIssueDate;
    }
}
