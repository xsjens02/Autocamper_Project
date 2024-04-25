package com.example.autocamper_project;

import java.util.Date;

public class RentalAgreement {
    private int rentalAgreementID;
    private Customer customer;
    private int employeeID;
    private AutoCamper autoCamper;
    private int insuranceID;
    private double price;
    private Date startDate;
    private Date endDate;
    private int mileageOut;
    private int mileageIn;
    private int fuelOut;
    private int fuelIn;
    private int seasonID;

    public RentalAgreement(Customer customer, int employeeID, AutoCamper autocamper, int insuranceID, double price, Date startDate, Date endDate, int seasonID) {
        this.customer = customer;
        this.employeeID = employeeID;
        this.autoCamper = autocamper;
        this.insuranceID = insuranceID;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.seasonID = seasonID;
    }

    public RentalAgreement(int rentalAgreementID, Customer customer, int employeeID, AutoCamper autoCamper, int insuranceID, double price, Date startDate, Date endDate, int mileageOut, int mileageIn, int fuelOut, int fuelIn, int seasonID) {
        this.rentalAgreementID = rentalAgreementID;
        this.customer = customer;
        this.employeeID = employeeID;
        this.autoCamper = autoCamper;
        this.insuranceID = insuranceID;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mileageOut = mileageOut;
        this.mileageIn = mileageIn;
        this.fuelOut = fuelOut;
        this.fuelIn = fuelIn;
        this.seasonID = seasonID;
    }

    public int getRentalAgreementID() {
        return rentalAgreementID;
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public AutoCamper getAutoCamper() {
        return autoCamper;
    }
    public int getInsuranceID() {
        return insuranceID;
    }
    public double getPrice() {
        return price;
    }
    public java.sql.Date getStartDate() {
        return (java.sql.Date) startDate;
    }
    public java.sql.Date getEndDate() {
        return (java.sql.Date) endDate;
    }
    public int getMileageOut() {
        return mileageOut;
    }
    public int getMileageIn() {
        return mileageIn;
    }
    public int getFuelOut() {
        return fuelOut;
    }
    public int getFuelIn() {
        return fuelIn;
    }
    public int getSeasonID() {
        return seasonID;
    }

    public void setRentalAgreementID(int rentalAgreementID) {
        this.rentalAgreementID = rentalAgreementID;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setAutoCamper(AutoCamper autoCamper) {
        this.autoCamper = autoCamper;
    }
    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setMileageOut(int mileageOut) {
        this.mileageOut = mileageOut;
    }
    public void setMileageIn(int mileageIn) {
        this.mileageIn = mileageIn;
    }
    public void setFuelOut(int fuelOut) {
        this.fuelOut = fuelOut;
    }
    public void setFuelIn(int fuelIn) {
        this.fuelIn = fuelIn;
    }
    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }
}
