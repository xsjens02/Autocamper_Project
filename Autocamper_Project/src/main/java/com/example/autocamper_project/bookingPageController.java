package com.example.autocamper_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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

    private DriverPageController driverPageController;

    public void setDriverPageController(DriverPageController controller){
        this.driverPageController = controller;
    }

    @FXML
    private void onLoadCustomerDataButtonClick(){

    }
    @FXML
    private void onCreateCustomerButtonClick(){

    }
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

    private List<Driver> collectionOfDrivers = new ArrayList<>();
    public void loadListOfDrivers(Driver newDriver){
        listOfDrivers.getItems().clear();
        collectionOfDrivers.add(newDriver);

        listOfDrivers.getItems().addAll(collectionOfDrivers);




    }


}
