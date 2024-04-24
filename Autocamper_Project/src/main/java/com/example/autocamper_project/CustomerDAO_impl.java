package com.example.autocamper_project;

import java.sql.*;
import java.util.List;

public class CustomerDAO_impl implements DAO<Customer> {
    private final Connection connection;
    public CustomerDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }
    @Override
    public boolean add(Customer entity) {
        try {
            CallableStatement addCustomer = connection.prepareCall("{call add_customer(?, ?, ?, ?, ?, ?, ?)}");
            addCustomer.setString(1, entity.getName());
            addCustomer.setString(2, entity.getEmail());
            addCustomer.setString(3, entity.getPhoneNumber());
            addCustomer.setString(4, entity.getStreet());
            addCustomer.setString(5, entity.getCity());
            addCustomer.setString(6, entity.getZipcode());
            addCustomer.setString(7, entity.getCountryCode());

            int result = addCustomer.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer read(int id) {
        PreparedStatement readCustomer;
        try {
            readCustomer = connection.prepareStatement("SELECT * FROM tblCustomer WHERE fldCustomerID=" + id);
            ResultSet customerData = readCustomer.executeQuery();
            while (customerData.next()) {
                int customerID = customerData.getInt(1);
                String name = customerData.getString(2).trim();
                String email = customerData.getString(3).trim();
                String phoneNumber = customerData.getString(4).trim();
                String street = customerData.getString(5).trim();
                String city = customerData.getString(6).trim();
                String zipcode = customerData.getString(7).trim();
                String countryCode = customerData.getString(8).trim();
                int amountRentals = customerData.getInt(9);
                return new Customer(customerID, name, email, phoneNumber, street, city, zipcode, countryCode, amountRentals);
            }
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Customer> readAll() {
        return null;
    }

    @Override
    public boolean remove(int id) {
        try {
            PreparedStatement removeCustomer = connection.prepareStatement("DELETE FROM tblCustomer WHERE fldCustomerID=" + id);
            int result = removeCustomer.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }
}
