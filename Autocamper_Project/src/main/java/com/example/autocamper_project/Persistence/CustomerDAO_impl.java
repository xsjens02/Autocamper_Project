package com.example.autocamper_project.Persistence;

import com.example.autocamper_project.Model.Customer;

import java.sql.*;
import java.util.List;

public class CustomerDAO_impl implements DAO<Customer> {
    private final Connection connection;
    public CustomerDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }

    /**
     * method for adding a new customer to database
     * @param entity customer object to add
     * @return true if added, false if not added
     */
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

    /**
     * method for getting a customer object from database based on id
     * @param id to search for specific customer
     * @return if id is present then new customer object else null
     */
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

    /**
     * method for getting an id of a customer object from database
     * @param customer object to search for id
     * @return id of customer object
     */
    public int getID(Customer customer) {
        try {
            CallableStatement getID = connection.prepareCall("{? = call get_customer_id(?, ?, ?, ?, ?, ?, ?)}");
            getID.registerOutParameter(1, Types.INTEGER);
            getID.setString(2, customer.getName());
            getID.setString(3, customer.getEmail());
            getID.setString(4, customer.getPhoneNumber());
            getID.setString(5, customer.getStreet());
            getID.setString(6, customer.getCity());
            getID.setString(7, customer.getZipcode());
            getID.setString(8, customer.getCountryCode());

            getID.execute();
            return getID.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
