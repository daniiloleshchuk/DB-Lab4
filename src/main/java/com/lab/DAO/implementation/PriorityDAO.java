package com.lab.DAO.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.model.implementation.Employee;
import com.lab.model.implementation.Priority;
import com.lab.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PriorityDAO implements GeneralDAOInterface<Priority, Integer> {

    private static final String GET_ALL = "SELECT * FROM oleshchuk_db.priority";
    private static final String GET_BY_ID = "SELECT * FROM oleshchuk_db.priority WHERE id=?";
    private static final String CREATE = "INSERT oleshchuk_db.priority (id, level) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE oleshchuk_db.priority SET level=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oleshchuk_db.employee WHERE id=?";


    @Override
    public List<Priority> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Priority> priorities = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String level = resultSet.getString(2);
                    priorities.add(new Priority(id, level));
                }
            }
        }
        return priorities;
    }

    @Override
    public Priority getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Priority priority = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String level = resultSet.getString(2);
                    priority = new Priority(foundId, level);
                }
            }
        }

        return priority;
    }

    @Override
    public int create(Priority entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLevel());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Priority entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getLevel());
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
