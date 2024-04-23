package com.example.autocamper_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class mainViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onNewBookingButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}