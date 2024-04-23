package com.example.autocamper_project;

public class AutoCamper {

    private String autoCamperID;
    private String autoCamperName;
    private double price;
    private String facilities;
    private Category category;

    public String getAutoCamperID() {
        return autoCamperID;
    }

    public void setAutoCamperID(String autoCamperID) {
        this.autoCamperID = autoCamperID;
    }

    public String getAutoCamperName() {
        return autoCamperName;
    }

    public void setAutoCamperName(String autoCamperName) {
        this.autoCamperName = autoCamperName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}