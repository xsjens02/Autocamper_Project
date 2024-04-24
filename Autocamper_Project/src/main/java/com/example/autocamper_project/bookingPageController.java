package com.example.autocamper_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class bookingPageController {

    @FXML
    private TextField orderNumber;
    @FXML
    private TextField customerID;
    @FXML
    private TextField phoneNum;
    @FXML
    private Button loadCustomerData;
    @FXML
    private TextField employeeID;
    @FXML
    private Label discountRate;
    @FXML
    private TextField fullName;
    @FXML
    private TextField adress;
    @FXML
    private TextField zipcode;
    @FXML
    private TextField city;
    @FXML
    private TextField country;
    @FXML
    private TextField email;
    @FXML
    private TextField driverLicenseNum;
    @FXML
    private DatePicker dateOfIssue;
    @FXML
    private Button createCustomer;
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

        new Customer(phoneNum.getText(), fullName.getText(), email.getText(), adress.getText(), zipcode.getText(), city.getText(), country.getText(), driverLicenseNum.getText(), dateOfIssue);

    }
    @FXML
    private void onCalculatePriceButtonClick(){

    }
    @FXML
    private void onConfirmBookingButtonClick(){
        loadListOfAutocampers();
    }
    @FXML
    private void onCancelBookingButtonClick(){

    }



    public void loadListOfAutocampers(){

        DAO dao = new AutoCamperDAO_impl();
        List al = dao.readAll();
        AutoCamper ac = new AutoCamper();
        ArrayList<String> allAutocampers = new ArrayList();
        for (int i = 0; i < al.size(); i++) {
            allAutocampers.add(ac.autoCamperString((AutoCamper) al.get(i)));
        }
        listOfAutocampers.getItems().addAll(allAutocampers);
    }


}
