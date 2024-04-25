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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public java.sql.Date getLicenseIssueDate() {
        return (java.sql.Date) licenseIssueDate;
    }

    public void setLicenseIssueDate(Date licenseIssueDate) {
        this.licenseIssueDate = licenseIssueDate;
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

    @Override
    public String toString() {
        return "Name: " + fullName + ", License Number: " + license + ", Issue Date: " + licenseIssueDate + ", Street: " + street + ", City: " + city + ", Zipcode: " + zipcode + ", Country Code: " + countryCode;
    }
}
