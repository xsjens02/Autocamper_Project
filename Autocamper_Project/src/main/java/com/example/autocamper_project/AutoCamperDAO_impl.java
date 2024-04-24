package com.example.autocamper_project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public AutoCamper read(int id) {
        try {
            CallableStatement callableStatement = connection.prepareCall("EXEC dbo.findAutocamper @AutocamperID = "+id);
            callableStatement.execute();
            ResultSet rs = callableStatement.getResultSet();
            while(rs.next()){
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
            }
        } catch (SQLException e) {
            System.err.println("In read method, could not SELECT"+e.getMessage());
        }
        return null;
    }

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
}
