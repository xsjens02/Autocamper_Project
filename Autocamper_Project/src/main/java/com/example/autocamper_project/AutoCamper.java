package com.example.autocamper_project;

public class AutoCamper {

    private int autoCamperID;
    private String autoCamperName;
    private String facilities;
    private int category;

    /**
     * Default constructor
     */
    public AutoCamper(){};

    /**
     * Constructor used when creating autocamper objects to lists and other instances
     * @param autoCamperID
     * @param autoCamperName
     * @param facilities
     * @param category
     */
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
    public String getAutoCamperName() {
        return autoCamperName;
    }
    public String getFacilities() {
        return facilities;
    }
    public int getCategory() {
        return category;
    }
}
