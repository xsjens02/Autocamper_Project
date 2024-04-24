package com.example.autocamper_project;

import java.sql.Connection;
import java.util.List;

public class CustomerDAO_impl implements DAO<Customer> {
    private final Connection connection;
    public CustomerDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }
    @Override
    public boolean add(Customer entity) {
        return false;
    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public List<Customer> readAll() {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }
}
