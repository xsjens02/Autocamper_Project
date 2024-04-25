package com.example.autocamper_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class bookingPageController {

    @FXML
    private TextField orderNumber, customerID, phoneNumberID, employeeID;
    @FXML
    private Button loadCustomerData;
    @FXML
    private Label discountRate;
    @FXML
    private TextField fullName, address, zipcode, city, country, email;
    @FXML
    private Button createCustomer;
    @FXML
    private Button addDriver;
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
    private void onAddDriverButtonClick(){

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
