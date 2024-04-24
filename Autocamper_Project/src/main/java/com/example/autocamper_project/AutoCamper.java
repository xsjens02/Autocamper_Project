package com.example.autocamper_project;

public class AutoCamper {

    private int autoCamperID;
    private String autoCamperName;
    private double price;
    private String facilities;
    private int category;

    public AutoCamper(){};
    public AutoCamper(int autoCamperID, String autoCamperName, String facilities, int category){
        this.autoCamperID = autoCamperID;
        this.autoCamperName = autoCamperName;
        this.facilities = facilities;
        this.category = category;
    }
    public String autoCamperString(AutoCamper a){
        return "ID: "+a.getAutoCamperID()+" | Name: "+a.getAutoCamperName()+" | Facilities: "+a.getFacilities()+" | Category: "+a.getCategory();
    }

    public int getAutoCamperID() {
        return autoCamperID;
    }

    public void setAutoCamperID(int autoCamperID) {
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
