package com.example.autocamper_project;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class bookingPageController implements Initializable {

    private final CustomerDAO_impl customerDAO = new CustomerDAO_impl();
    private final RentalAgreementDAO_impl rentalDAO = new RentalAgreementDAO_impl();

    private int discountRate = 0;

    private Customer customer;

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
    private ComboBox<String> chooseInsurance;
    @FXML
    private Button calculatePrice;
    @FXML
    private Label totalPrice;
    @FXML
    private Button confirmBooking;
    @FXML
    private Button cancelBooking;


    private DriverPageController driverPageController;

    public void setDriverPageController(DriverPageController controller){
        this.driverPageController = controller;
    }


    private AutoCamper autoCamper;
    private int selectedAutocamperID;
    private int selectedAutocamperCategoryID;
    private int seasonID;
    private int insuranceID;

    @FXML
    private void onLoadCustomerDataButtonClick(){
        resetTextFields();
        String searchID = customerID.getText();
        if (isInteger(searchID)) {
            customer = customerDAO.read(Integer.parseInt(searchID));
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
            ArrayList<TextField> textFields = new ArrayList<>(Arrays.asList(fullName, address, zipcode, city, country, phoneNumber, email));
            if (fieldsNotEmpty(textFields)) {
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
                    int id = customerDAO.getID(newCustomer);
                    customerID.setText(String.valueOf(id));
                    customer = customerDAO.read(id);

                    discountRate = calculateDiscount(customer.getAmountRentals());
                    lblDiscountRate.setText("Discount rate: " + discountRate + "%");
                }
            }
        }
    }

    private boolean fieldsNotEmpty(ArrayList<TextField> textFields) {
        boolean valid = true;
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

    /**
     * Method that goes to a new scene called addDriverPage, where you can add a driver
     */
    @FXML
    private void onAddDriverButtonClick(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addDriverPage.fxml"));
            Parent root = loader.load();
            Button button = new Button();


            //Scene scene = new Scene(root);

            Stage addDriverStage = new Stage();
            addDriverStage.initModality(Modality.APPLICATION_MODAL);
            addDriverStage.setTitle("Add Driver");
            addDriverStage.setScene(new Scene(root));

            addDriverStage.showAndWait();

            //Stage stage = (Stage) addDriver.getScene().getWindow();

            //setNewScene(stage, scene);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private void setNewScene(Stage stage, Scene scene){
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void onCalculatePriceButtonClick(){
        totalPrice.setText("Total price: "+calculateTotalPrice());
    }
    @FXML
    private void onConfirmBookingButtonClick(){
        ArrayList<TextField> textFields = new ArrayList<>(Arrays.asList(customerID, employeeID));
        if (fieldsNotEmpty(textFields)) {
            if (customer != null && autoCamper != null) {
                try {
                    int employee = Integer.parseInt(employeeID.getText());
                    double price = calculateTotalPrice();
                    Date start = java.sql.Date.valueOf(startDate.getValue());
                    Date end = java.sql.Date.valueOf(endDate.getValue());

                    RentalAgreement newRental = new RentalAgreement(customer, employee, autoCamper, insuranceID, price, start, end, seasonID);
                    boolean rentalAdded = rentalDAO.add(newRental);
                    if (rentalAdded) {
                        int rentalID = rentalDAO.getID(newRental);
                        orderNumber.setText(String.valueOf(rentalID));
                    }
                } catch (Exception e) {
                    System.out.println("creating rental agreement failed");
                }
            }

        }
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

    /**
     * Method that should be able to get that information from the DriverPageController and display it in
     * the listview.
     * WIP.
     */
    private List<Driver> collectionOfDrivers = new ArrayList<>();
    public void loadListOfDrivers(Driver newDriver){
        listOfDrivers.getItems().clear();
        collectionOfDrivers.add(newDriver);

        listOfDrivers.getItems().addAll(collectionOfDrivers);




    }



    public List<Integer> findAllBookedAutocampers(){

        List allBookedAutocampersID = new ArrayList();
        AutoCamperDAO_impl dao = new AutoCamperDAO_impl();
        return allBookedAutocampersID = dao.readAllBookedAutocampers(startDate.getValue(),endDate.getValue());
    }

    public double calculateTotalPrice(){

        AutoCamperDAO_impl dao = new AutoCamperDAO_impl();
        autoCamper = dao.read(selectedAutocamperID);

        double insurancePrice = 0;
        if (chooseInsurance.getSelectionModel().getSelectedIndex() == 0) {
            insuranceID = 1;
        } else if (chooseInsurance.getSelectionModel().getSelectedIndex()==1){
            insurancePrice = 500;
            insuranceID = 2;
        }
        else if(chooseInsurance.getSelectionModel().getSelectedIndex()==2){
            insurancePrice = 1000;
            insuranceID = 3;
        }
        double categoryPrice = dao.getCategoryPrice(autoCamper.getCategory());
        int seasonPriceModifier = 0;
        if(seasonID==1){
            seasonPriceModifier = 2;
        }
        else{
            seasonPriceModifier = 1;
        }

        if (discountRate != 0) {
            return ((categoryPrice*seasonPriceModifier)+insurancePrice) * (1 - (discountRate / 100.0));
        } else {
            return (categoryPrice*seasonPriceModifier)+insurancePrice;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chooseInsurance.getItems().addAll("No Insurance", "Basic Cover", "Super Cover Plus");
    }
}
