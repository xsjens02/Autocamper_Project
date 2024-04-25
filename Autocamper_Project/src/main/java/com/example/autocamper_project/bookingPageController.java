package com.example.autocamper_project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
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
    private int selectedAutocamperID;
    private int selectedAutocamperCategoryID;
    private int seasonID = 1;
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
        totalPrice.setText("Total price: "+calculateTotalPrice());
    }
    @FXML
    private void onConfirmBookingButtonClick(){
    }
    @FXML
    private void onCancelBookingButtonClick(){

    }
    public void loadListOfAutocampers(){

        listOfAutocampers.getItems().clear();
        DAO dao = new AutoCamperDAO_impl();
        List allAutocampers = dao.readAll();
        AutoCamper ac = new AutoCamper();
        ArrayList<String> allAutocampersAsStrings = new ArrayList();
        List<Integer> allBookedAutocampersID = findAllBookedAutocampers();
        System.out.println(allBookedAutocampersID);


        for (int i = 1; i <= allBookedAutocampersID.size(); i++) {
            int ID = allBookedAutocampersID.get(i-1);
            allAutocampers.remove(ID-i);
        }


        for (int i = 0; i < allAutocampers.size(); i++) {
            allAutocampersAsStrings.add(ac.autoCamperString((AutoCamper) allAutocampers.get(i)));
        }
        listOfAutocampers.getItems().addAll(allAutocampersAsStrings);

        listOfAutocampers.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            selectedAutocamperID = listOfAutocampers.getSelectionModel().getSelectedIndex() + 1;
        });

    }

    @FXML
    public void checkSeason(){

        LocalDate seasonStartDate = startDate.getValue();
        if(seasonStartDate.getMonth().getValue()>=4 && seasonStartDate.getMonth().getValue()<10){
            seasonID = 1;
        }
        else{
            seasonID = 2;
        }

    }



    public List<Integer> findAllBookedAutocampers(){

        List allBookedAutocampersID = new ArrayList();
        AutoCamperDAO_impl dao = new AutoCamperDAO_impl();
        return allBookedAutocampersID = dao.readAllBookedAutocampers(startDate.getValue(),endDate.getValue());
    }

    public double calculateTotalPrice(){

        AutoCamperDAO_impl dao = new AutoCamperDAO_impl();
        AutoCamper ac = dao.read(selectedAutocamperID);

        double insurancePrice = 0;
        if(chooseInsurance.getSelectionModel().getSelectedIndex()==1){
            insurancePrice = 500;
        }
        else if(chooseInsurance.getSelectionModel().getSelectedIndex()==2){
            insurancePrice = 1000;
        }
        double categoryPrice = dao.getCategoryPrice(ac.getCategory());
        int seasonPriceModifier = 0;
        if(seasonID==1){
            seasonPriceModifier = 2;
        }
        else{
            seasonPriceModifier = 1;
        }

        return (categoryPrice*seasonPriceModifier)+insurancePrice;
    }

}
