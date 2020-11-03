package com.lab.DAO.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.model.implementation.Employee;
import com.lab.persistance.ConnectionManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAO implements IGeneralDAO<Employee, Integer> {

    private static final String GET_ALL = "SELECT * FROM oleshchuk_db.employee";
    private static final String GET_BY_ID = "SELECT * FROM oleshchuk_db.employee WHERE id=?";
    private static final String CREATE = "INSERT oleshchuk_db.employee "
            + "(id, name, surname, working_position_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE oleshchuk_db.employee"
            + " SET name=?, surname=?, working_position_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oleshchuk_db.employee WHERE id=?";

    @Override
    public final List<Employee> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Employee> employees = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    Integer workingPositionId = resultSet.getInt(4);
                    employees.add(new Employee(id, name, surname, workingPositionId));
                }
            }
        }
        return employees;
    }

    @Override
    public final Employee getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Employee employee = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    Integer workingPositionId = resultSet.getInt(4);
                    employee = new Employee(foundId, name, surname, workingPositionId);
                }
            }
        }

        return employee;
    }

    @Override
    public final int create(final Employee entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getSurname());
            ps.setInt(4, entity.getWorkingPositionId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Employee entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSurname());
            ps.setInt(3, entity.getWorkingPositionId());
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
