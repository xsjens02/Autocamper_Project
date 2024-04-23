package com.example.autocamper_project;

import java.util.Date;
import java.util.List;

public class RentalAgreement {
    private double price;
    private Date startDate;
    private Date endDate;
    private Customer renter;
    private String employeeID;
    private String rentalAgreementID;
    private List<Driver> additionalDrivers;
    private AutoCamper autoCamper;
    private double mileageOut;
    private double mileageIn;
    private int fuelOut;
    private int fuelIn;
    private String insurance;
    private boolean isDamaged;
    private int discountRate;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Customer getRenter() {
        return renter;
    }

    public void setRenter(Customer renter) {
        this.renter = renter;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRentalAgreementID() {
        return rentalAgreementID;
    }

    public void setRentalAgreementID(String rentalAgreementID) {
        this.rentalAgreementID = rentalAgreementID;
    }

    public List<Driver> getAdditionalDrivers() {
        return additionalDrivers;
    }

    public void setAdditionalDrivers(List<Driver> additionalDrivers) {
        this.additionalDrivers = additionalDrivers;
    }

    public AutoCamper getAutoCamper() {
        return autoCamper;
    }

    public void setAutoCamper(AutoCamper autoCamper) {
        this.autoCamper = autoCamper;
    }

    public double getMileageOut() {
        return mileageOut;
    }

    public void setMileageOut(double mileageOut) {
        this.mileageOut = mileageOut;
    }

    public double getMileageIn() {
        return mileageIn;
    }

    public void setMileageIn(double mileageIn) {
        this.mileageIn = mileageIn;
    }

    public int getFuelOut() {
        return fuelOut;
    }

    public void setFuelOut(int fuelOut) {
        this.fuelOut = fuelOut;
    }

    public int getFuelIn() {
        return fuelIn;
    }

    public void setFuelIn(int fuelIn) {
        this.fuelIn = fuelIn;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}
