package com.example.autocamper_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DriverPageController {

    private final DriverDAO_impl driverDAOImpl = new DriverDAO_impl();


    @FXML
    private TextField tfFullName;
    @FXML
    private TextField tfStreet;
    @FXML
    private TextField tfZipcode;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfCountryCode;
    @FXML
    private DatePicker dpIssueDate;
    @FXML
    private TextField tfLicenseNumber;
    @FXML
    private Button btnAddDriver;

    List<Driver> newlyAddedDriver = new ArrayList<>();

    private bookingPageController bookingController;

    public void setBookingController(bookingPageController controller){
        this.bookingController = controller;
    }

    private Stage bookingPage;

    public void setBookingPage(Stage bookingPage){
        this.bookingPage = bookingPage;
    }

    /**
     * Method that executes when clicking on the Add Driver button, that gets the information from the text fields
     * and sends that information to the database
     * @param actionEvent
     */
    public void onAddDriverClick(ActionEvent actionEvent) {
        String name = tfFullName.getText();
        String street = tfStreet.getText();
        String zipCode = tfZipcode.getText();
        String city = tfCity.getText();
        String countryCode = tfCountryCode.getText();

        LocalDate localDate = dpIssueDate.getValue();
        Date issueDate = null;

        if(localDate != null){
            issueDate = Date.valueOf(localDate.format(DateTimeFormatter.ISO_DATE));
        }

        String licenseNumber = tfLicenseNumber.getText();


        Driver newDriver = new Driver(name, licenseNumber, issueDate, street, city, zipCode, countryCode);

        boolean success = driverDAOImpl.add(newDriver);

        if(success){
            System.out.println("Driver added successfully");
            tfFullName.clear();
            tfLicenseNumber.clear();
            tfCity.clear();
            tfZipcode.clear();
            tfCountryCode.clear();
            tfStreet.clear();
            dpIssueDate.setValue(null);

            newlyAddedDriver.add(newDriver);


            FXMLLoader loader = new FXMLLoader(getClass().getResource("bookingPage.fxml"));

            bookingPageController bookingController = new bookingPageController();
            Stage stage = (Stage) btnAddDriver.getScene().getWindow();
            stage.close();

            bookingController.setDriverPageController(this);

            bookingController.loadListOfDrivers(newDriver);



        }else {
            System.out.println("Failed to add driver");
        }

    }


}
