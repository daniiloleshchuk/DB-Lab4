package com.lab.DAO.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.model.implementation.Employee;
import com.lab.model.implementation.InitiatingEmployee;
import com.lab.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class InitiatingEmployeeDAO implements GeneralDAOInterface<InitiatingEmployee, Integer> {

    private static final String GET_ALL = "SELECT * FROM oleshchuk_db.Initiating_employee";
    private static final String GET_BY_ID = "SELECT * FROM oleshchuk_db.Initiating_employee WHERE id=?";
    private static final String CREATE = "INSERT oleshchuk_db.Initiating_employee (id, employee_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE oleshchuk_db.Initiating_employee SET employee_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oleshchuk_db.Initiating_employee WHERE id=?";

    @Override
    public List<InitiatingEmployee> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<InitiatingEmployee> initiatingEmployees = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer employeeId = resultSet.getInt(2);
                    initiatingEmployees.add(new InitiatingEmployee(id, employeeId));
                }
            }
        }
        return initiatingEmployees;
    }

    @Override
    public InitiatingEmployee getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        InitiatingEmployee initiatingEmployee = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer employeeId = resultSet.getInt(2);
                    initiatingEmployee = new InitiatingEmployee(foundId, employeeId);
                }
            }
        }

        return initiatingEmployee;
    }

    @Override
    public int create(InitiatingEmployee entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getEmployeeId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(InitiatingEmployee entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getEmployeeId());
            ps.setInt(2, entity.getId());
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
