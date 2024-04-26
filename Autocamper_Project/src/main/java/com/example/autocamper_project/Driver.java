package com.example.autocamper_project;

import java.util.Date;

public class Driver {
    private String fullName;
    private String license;
    private Date licenseIssueDate;
    private String street;
    private String city;
    private String zipcode;
    private String countryCode;

    /**
     * Constructor for the Driver
     * @param name
     * @param licenseNumber
     * @param licenseIssueDate
     * @param street
     * @param city
     * @param zipcode
     * @param countryCode
     */
    public Driver(String name, String licenseNumber, java.sql.Date licenseIssueDate, String street, String city, String zipcode, String countryCode) {
        this.fullName = name;
        this.license = licenseNumber;
        this.licenseIssueDate = licenseIssueDate;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.countryCode = countryCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLicense() {
        return license;
    }


    public java.sql.Date getLicenseIssueDate() {
        return (java.sql.Date) licenseIssueDate;
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

    @Override
    public String toString() {
        return "Name: " + fullName + ", License Number: " + license + ", Issue Date: " + licenseIssueDate + ", Street: " + street + ", City: " + city + ", Zipcode: " + zipcode + ", Country Code: " + countryCode;
    }
}
