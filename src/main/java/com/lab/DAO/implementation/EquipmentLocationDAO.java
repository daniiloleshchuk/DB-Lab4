package com.lab.DAO.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.model.implementation.EquipmentLocation;
import com.lab.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EquipmentLocationDAO implements GeneralDAOInterface<EquipmentLocation, Integer> {

    private static final String GET_ALL = "SELECT * FROM oleshchuk_db.equipment_location";
    private static final String GET_BY_ID = "SELECT * FROM oleshchuk_db.equipment_location WHERE id=?";
    private static final String CREATE = "INSERT oleshchuk_db.equipment_location (id, office, room_number, working_place_number) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE oleshchuk_db.equipment_location SET office=?, room_number=?, working_place_number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oleshchuk_db.employee WHERE id=?";

    @Override
    public List<EquipmentLocation> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<EquipmentLocation> equipmentLocations = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String office = resultSet.getString(2);
                    Integer roomNumber = resultSet.getInt(3);
                    Integer workingPlaceNumber = resultSet.getInt(4);
                    equipmentLocations.add(new EquipmentLocation(id, office, roomNumber, workingPlaceNumber));
                }
            }
        }
        return equipmentLocations;
    }

    @Override
    public EquipmentLocation getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        EquipmentLocation equipmentLocation = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String office = resultSet.getString(2);
                    Integer roomNumber = resultSet.getInt(3);
                    Integer workingPlaceNumber = resultSet.getInt(4);
                    equipmentLocation = new EquipmentLocation(foundId, office, roomNumber, workingPlaceNumber);
                }
            }
        }

        return equipmentLocation;
    }

    @Override
    public int create(EquipmentLocation entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getOffice());
            ps.setInt(3, entity.getRoomNumber());
            ps.setInt(4, entity.getWorkingPlaceNumber());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(EquipmentLocation entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getOffice());
            ps.setInt(2, entity.getRoomNumber());
            ps.setInt(3, entity.getWorkingPlaceNumber());
            ps.setInt(4, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
