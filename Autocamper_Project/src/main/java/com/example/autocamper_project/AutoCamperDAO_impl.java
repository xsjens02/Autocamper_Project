package com.example.autocamper_project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutoCamperDAO_impl implements DAO<AutoCamper> {
    private final Connection connection;
    public AutoCamperDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }

    @Override
    public boolean add(AutoCamper entity) {
        return false;
    }

    /**
     * Method that takes an integer parameter to find a specific Autocamper in the database.
     * @param id an integer that is used to find the matching AutocamperID in the database
     * @return The method returns the autocamper from the database with the corresponding AutocamperID to the int parameter
     */
    @Override
    public AutoCamper read(int id) {
        AutoCamper ac = new AutoCamper();
        try {
            CallableStatement callableStatement = connection.prepareCall("EXEC dbo.findAutocamper @AutocamperID = "+id);
            callableStatement.execute();
            ResultSet rs = callableStatement.getResultSet();
            while(rs.next()){
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i = i +4) {
                    System.out.print(rs.getString(i) + "\t");
                    ac = new AutoCamper(rs.getInt(i),rs.getString(i+1), rs.getString(i+2),rs.getInt(i+3));
                }
            }
        } catch (SQLException e) {
            System.err.println("In read method, could not SELECT"+e.getMessage());
        }
        return ac;
    }

    /**
     * This method uses a stored procedure in the database to select all autocampers from the tblAutocampers.
     * @return A List of Autocamper objects are returned.
     */
    @Override
    public List<AutoCamper> readAll() {
        List<AutoCamper> allAutocampers = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("EXEC showAllAutocampers");
            callableStatement.executeQuery();
            ResultSet rs = callableStatement.getResultSet();
            while(rs.next()){
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i = i+4) {
                    allAutocampers.add(new AutoCamper(rs.getInt(i),rs.getString(i+1), rs.getString(i+2),rs.getInt(i+3)));
                }
            }
        } catch (SQLException e) {
            System.err.println("In readAll method, could not SELECT"+e.getMessage());
        }
        return allAutocampers;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(AutoCamper entity) {
        return false;
    }

    /**
     * Based on two parameters 'startDate' and 'endDate' this method finds all autocamperIDs that are booked within the period.
     * @param startDate is the selected startDate in the DatePicker
     * @param endDate is the selected endDate in the DatePicker
     * @returns a list of integers that represents the autocamperIDs of all the booked autocampers.
     */
    public List<Integer> readAllBookedAutocampers(LocalDate startDate, LocalDate endDate){

        List<Integer> allBookedAutocampersID = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("EXEC showAllBookedAutocampersID @startDate='"+startDate+"', @endDate='"+endDate+"'");
            callableStatement.executeQuery();
            ResultSet rs = callableStatement.getResultSet();
            while(rs.next()){
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    allBookedAutocampersID.add(rs.getInt(i));
                }
            }
        } catch (SQLException e) {
            System.err.println("In readAllBookedAutocampers method, could not SELECT"+e.getMessage());
        }
        return allBookedAutocampersID;
    }

    /**
     * In order to associate a specific autocamper with a certain price, each autocamper has a categoryID and
     * each category has a price. Here the methods finds the price corresponding to the categoryID on the autocamper.
     * @param categoryID an int to match with the categoryID in the database.
     * @returns the price of the selected category.
     */
    public double getCategoryPrice(int categoryID){

        double categoryPrice = 0;
        try {
            CallableStatement callableStatement = connection.prepareCall("EXEC getCategoryprice @categoryID="+categoryID+";");
            callableStatement.executeQuery();
            ResultSet rs = callableStatement.getResultSet();
            while(rs.next()){
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                    categoryPrice = rs.getDouble(i);
                }
            }
        } catch (SQLException e) {
            System.err.println("In getCategoryPrice method, could not SELECT"+e.getMessage());
        }

        return categoryPrice;
    }
}
