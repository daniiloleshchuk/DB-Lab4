package com.lab.DAO.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.model.implementation.WorkingPosition;
import com.lab.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class WorkingPositionDAO implements GeneralDAOInterface<WorkingPosition, Integer>  {

    private static final String GET_ALL = "SELECT * FROM oleshchuk_db.working_position";
    private static final String GET_BY_ID = "SELECT * FROM oleshchuk_db.working_position WHERE id=?";
    private static final String CREATE = "INSERT oleshchuk_db.working_position (id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE oleshchuk_db.working_position SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oleshchuk_db.working_position WHERE id=?";

    @Override
    public List<WorkingPosition> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<WorkingPosition> workingPositions = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    workingPositions.add(new WorkingPosition(id, name));
                }
            }
        }
        return workingPositions;
    }

    @Override
    public WorkingPosition getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        WorkingPosition workingPosition = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    workingPosition = new WorkingPosition(foundId, name);
                }
            }
        }

        return workingPosition;
    }

    @Override
    public int create(WorkingPosition entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(WorkingPosition entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
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
