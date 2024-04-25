package com.example.autocamper_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class bookingPageController {

    private final CustomerDAO_impl customerDAO = new CustomerDAO_impl();

    private int discountRate;

    @FXML
    private TextField orderNumber, customerID, employeeID;
    @FXML
    private Button loadCustomerData;
    @FXML
    private Label lblDiscountRate;
    @FXML
    private TextField fullName, address, zipcode, city, country, phoneNumber, email;
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
        resetTextFields();
        String searchID = customerID.getText();
        if (isInteger(searchID)) {
            Customer customer = customerDAO.read(Integer.parseInt(searchID));
            if (customer != null) {
                fullName.setText(customer.getName());
                address.setText(customer.getStreet());
                zipcode.setText(customer.getZipcode());
                city.setText(customer.getCity());
                country.setText(customer.getCountryCode());
                phoneNumber.setText(customer.getPhoneNumber());
                email.setText(customer.getEmail());

                discountRate = calculateDiscount(customer.getAmountRentals());
                lblDiscountRate.setText("Discount rate: " + discountRate + "%");
            }
        }
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private int calculateDiscount(int amountOfRentals) {
        if (amountOfRentals > 2 && amountOfRentals < 6) {
            return 5;
        } else if (amountOfRentals > 5) {
            return 10;
        }
        return 0;
    }
    @FXML
    private void onCreateCustomerButtonClick(){
        if (customerID.getText().isEmpty()) {
            if (fieldsNotEmpty()) {
                String name = fullName.getText();
                String mail = email.getText();
                String phone = phoneNumber.getText();
                String street = address.getText();
                String town = city.getText();
                String zip = zipcode.getText();
                String countryCode = country.getText();
                Customer newCustomer = new Customer(name, mail, phone, street, town, zip, countryCode);
                boolean customerAdded = customerDAO.add(newCustomer);
                if (customerAdded) {
                    customerID.setText(String.valueOf(customerDAO.getID(newCustomer)));
                }
            }
        }
    }

    private boolean fieldsNotEmpty() {
        boolean valid = true;
        TextField[] textFields = {fullName, address, zipcode, city, country, phoneNumber, email};
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                textField.setText("required");
                textField.setStyle("-fx-text-fill: red;");
                if (valid) {
                    valid = false;
                }
                textField.setOnMouseClicked(e -> {
                    textField.setStyle("-fx-text-fill: black;");
                    textField.clear();
                });
            }
        }
        return valid;
    }

    private void resetTextFields() {
        TextField[] textFields = {fullName, address, zipcode, city, country, phoneNumber, email};
        for (TextField textField : textFields) {
            textField.setStyle("-fx-text-fill: black;");
            textField.clear();
        }
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
