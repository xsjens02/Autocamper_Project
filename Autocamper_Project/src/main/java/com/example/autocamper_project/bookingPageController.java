package com.example.autocamper_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.ZoneId;
import java.util.Date;

public class bookingPageController {

    @FXML
    private TextField orderNumber, customerID, phoneNumberID, employeeID;
    @FXML
    private Button loadCustomerData;
    @FXML
    private Label discountRate;
    @FXML
    private TextField fullName, address, zipcode, city, country, phoneNumber, email;
    @FXML
    private Button createCustomer;
    @FXML
    private DatePicker dateOfIssue;
    @FXML
    private ListView listOfDrivers;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private ListView listOfAutocampers;
    @FXML
    private ComboBox chooseInsurance;
    @FXML
    private Button calculatePrice;
    @FXML
    private Label totalPrice;
    @FXML
    private Button confirmBooking;
    @FXML
    private Button cancelBooking;
    @FXML
    private void onLoadCustomerDataButtonClick(){

    }
    @FXML
    private void onCreateCustomerButtonClick(){

    }
    @FXML
    private void onCalculatePriceButtonClick(){

    }
    @FXML
    private void onConfirmBookingButtonClick(){

    }
    @FXML
    private void onCancelBookingButtonClick(){

    }



}
