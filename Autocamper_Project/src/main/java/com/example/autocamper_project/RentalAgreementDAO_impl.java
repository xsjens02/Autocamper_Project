package com.example.autocamper_project;

import java.sql.*;
import java.util.List;

public class RentalAgreementDAO_impl implements DAO<RentalAgreement> {
    private final Connection connection;

    public RentalAgreementDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }
    @Override
    public boolean add(RentalAgreement entity) {
        try {
            CallableStatement addRA = connection.prepareCall("{call add_customer(?, ?, ?, ?, ?, ?, ?, ?)}");
            addRA.setInt(1, entity.getCustomer().getCustomerID());
            addRA.setInt(2, entity.getEmployeeID());
            addRA.setInt(3, entity.getAutoCamper().getAutoCamperID());
            addRA.setInt(4, entity.getInsuranceID());
            addRA.setDouble(5, entity.getPrice());
            addRA.setDate(6, entity.getStartDate());
            addRA.setDate(7, entity.getEndDate());
            addRA.setInt(8, entity.getSeasonID());

            int result = addRA.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public RentalAgreement read(int id) {
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
