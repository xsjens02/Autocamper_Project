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
    private Insurance insurance;
    private boolean isDamaged;
    private int discountRate;
}
