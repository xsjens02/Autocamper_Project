package com.example.autocamper_project;

import java.sql.*;
import java.util.List;

public class RentalAgreementDAO_impl implements DAO<RentalAgreement> {
    private final Connection connection;

    public RentalAgreementDAO_impl() {
        connection = dbConnection.getInstance().getConnection();
    }

    /**
     * method for adding a new rental agreement to database
     * @param entity rental agreement object to add in database
     * @return true if added, false if not added
     */
    @Override
    public boolean add(RentalAgreement entity) {
        try {
            CallableStatement addRA = connection.prepareCall("{call create_rentalAgreement(?, ?, ?, ?, ?, ?, ?, ?)}");
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

    /**
     * method for getting id for a rental agreement in database
     * @param rentalAgreement to get id for
     * @return id of rental agreement
     */
    public int getID(RentalAgreement rentalAgreement) {
        try {
            CallableStatement getID = connection.prepareCall("{? = call get_rental_id(?, ?, ?, ?, ?, ?, ?, ?)}");
            getID.registerOutParameter(1, Types.INTEGER);
            getID.setInt(2, rentalAgreement.getCustomer().getCustomerID());
            getID.setInt(3, rentalAgreement.getEmployeeID());
            getID.setInt(4, rentalAgreement.getAutoCamper().getAutoCamperID());
            getID.setInt(5, rentalAgreement.getInsuranceID());
            getID.setDouble(6, rentalAgreement.getPrice());
            getID.setDate(7, rentalAgreement.getStartDate());
            getID.setDate(8, rentalAgreement.getEndDate());
            getID.setInt(9, rentalAgreement.getSeasonID());

            getID.execute();
            return getID.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
