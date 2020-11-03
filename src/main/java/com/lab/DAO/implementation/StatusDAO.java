package com.lab.DAO.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.model.implementation.Status;
import com.lab.persistance.ConnectionManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class StatusDAO implements IGeneralDAO<Status, Integer> {

    private static final String GET_ALL = "SELECT * FROM oleshchuk_db.status";
    private static final String GET_BY_ID = "SELECT * FROM oleshchuk_db.status WHERE id=?";
    private static final String CREATE = "INSERT oleshchuk_db.status (id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE oleshchuk_db.status SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oleshchuk_db.status WHERE id=?";

    @Override
    public final List<Status> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Status> statuses = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    statuses.add(new Status(id, name));
                }
            }
        }
        return statuses;
    }

    @Override
    public final Status getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Status status = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    status = new Status(foundId, name);
                }
            }
        }

        return status;
    }

    @Override
    public final int create(final Status entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Status entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(4, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
