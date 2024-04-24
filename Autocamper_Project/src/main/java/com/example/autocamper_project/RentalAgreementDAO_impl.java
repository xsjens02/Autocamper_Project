package com.example.autocamper_project;

import java.sql.Connection;
import java.util.List;

public class RentalAgreementDAO_impl implements DAO<RentalAgreement> {
    private final Connection connection;

    public RentalAgreementDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }
    @Override
    public boolean add(RentalAgreement entity) {
        return false;
    }

    @Override
    public AutoCamper read(int id) {
        return null;
    }

    @Override
    public List<RentalAgreement> readAll() {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(RentalAgreement entity) {
        return false;
    }
}
