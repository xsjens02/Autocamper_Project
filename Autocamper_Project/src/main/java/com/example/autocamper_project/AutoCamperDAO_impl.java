package com.example.autocamper_project;

import java.sql.Connection;
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

    @Override
    public AutoCamper read(int id) {
        return null;
    }

    @Override
    public List<AutoCamper> readAll() {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(AutoCamper entity) {
        return false;
    }
}
