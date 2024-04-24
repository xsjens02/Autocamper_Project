package com.example.autocamper_project;

import java.sql.Connection;
import java.util.List;

public class DriverDAO_impl implements DAO<Driver> {
    private final Connection connection;

    public DriverDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }

    @Override
    public boolean add(Driver entity) {
        return false;
    }

    @Override
    public Driver read(int id) {
        return null;
    }

    @Override
    public List<Driver> readAll() {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(Driver entity) {
        return false;
    }
}
