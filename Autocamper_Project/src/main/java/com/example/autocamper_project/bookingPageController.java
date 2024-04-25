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
    }

    public List<Integer> findAllBookedAutocampers(){

        List allBookedAutocampersID = new ArrayList();
        AutoCamperDAO_impl dao = new AutoCamperDAO_impl();
        return allBookedAutocampersID = dao.readAllBookedAutocampers(startDate.getValue(),endDate.getValue());
    }


}
