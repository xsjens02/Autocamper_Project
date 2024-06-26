package com.example.autocamper_project.Persistence;

import com.example.autocamper_project.Model.Driver;
import com.example.autocamper_project.Persistence.DAO;
import com.example.autocamper_project.Persistence.dbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO_impl implements DAO<com.example.autocamper_project.Model.Driver> {
    private final Connection connection;

    /**
     * Method to establish a connection to the database
     */
    public DriverDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }

    /**
     * Method for adding a driver to the database
     * @param entity
     * @return
     */
    @Override
    public boolean add(com.example.autocamper_project.Model.Driver entity) {
        try(CallableStatement statement = connection.prepareCall("{CALL dbo.addDriver(?,?,?,?,?,?,?)}")){
            statement.setString(1,entity.getFullName());
            statement.setString(2,entity.getLicense());
            statement.setDate(3,entity.getLicenseIssueDate());
            statement.setString(4,entity.getStreet());
            statement.setString(5,entity.getCity());
            statement.setString(6,entity.getZipcode());
            statement.setString(7,entity.getCountryCode());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Method for reading a single driver in database
     * @param id
     * @return
     */
    @Override
    public com.example.autocamper_project.Model.Driver read(int id) {
        try(CallableStatement statement = connection.prepareCall("{CALL dbo.readDriver(?)}")){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("fldName");
                String licenseNumber = resultSet.getString("fldLicenseNumber");
                Date licenseIssueDate = resultSet.getDate("fldLicenseIssueDate");
                String street = resultSet.getString("fldStreet");
                String city = resultSet.getString("fldCity");
                String zipcode = resultSet.getString("fldZipcode");
                String countryCode = resultSet.getString("fldCountryCode");
                return new com.example.autocamper_project.Model.Driver(name, licenseNumber, licenseIssueDate, street, city, zipcode, countryCode);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method for reading all drivers in database
     * @return
     */
    @Override
    public List<com.example.autocamper_project.Model.Driver> readAll() {
        List<com.example.autocamper_project.Model.Driver> drivers = new ArrayList<>();
        try(CallableStatement statement = connection.prepareCall("{CALL dbo.readAllDrivers()}")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int driverID = resultSet.getInt("fldDriverID");
                String name = resultSet.getString("fldName");
                String licenseNumber = resultSet.getString("fldLicenseNumber");
                Date licenseIssueDate = resultSet.getDate("fldLicenseIssueDate");
                String street = resultSet.getString("fldStreet");
                String city = resultSet.getString("fldCity");
                String zipcode = resultSet.getString("fldZipcode");
                String countryCode = resultSet.getString("fldCountryCode");
                drivers.add(new com.example.autocamper_project.Model.Driver(name, licenseNumber, licenseIssueDate, street, city, zipcode, countryCode));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return drivers;
    }

    /**
     * Method for removing a driver in database
     * @param id
     * @return
     */
    @Override
    public boolean remove(int id) {
        try(CallableStatement statement = connection.prepareCall("{CALL dbo.deleteDriver(?)}")){
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method for updating a driver in the database
     * @param entity
     * @return
     */
    @Override
    public boolean update(Driver entity) {
        try(CallableStatement statement = connection.prepareCall("{CALL dbo.updateDriver(?, ?, ?, ?, ?, ?, ?)}")){
            statement.setString(1,entity.getFullName());
            statement.setString(2,entity.getLicense());
            statement.setDate(3,entity.getLicenseIssueDate());
            statement.setString(4,entity.getStreet());
            statement.setString(5,entity.getCity());
            statement.setString(6,entity.getZipcode());
            statement.setString(7,entity.getCountryCode());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }
}
