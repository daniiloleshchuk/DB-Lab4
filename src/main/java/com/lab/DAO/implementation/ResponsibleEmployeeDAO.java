package com.lab.DAO.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.model.implementation.InitiatingEmployee;
import com.lab.model.implementation.ResponsibleEmployee;
import com.lab.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ResponsibleEmployeeDAO implements GeneralDAOInterface<ResponsibleEmployee, Integer> {

    private static final String GET_ALL = "SELECT * FROM oleshchuk_db.responsible_employee";
    private static final String GET_BY_ID = "SELECT * FROM oleshchuk_db.responsible_employee WHERE id=?";
    private static final String CREATE = "INSERT oleshchuk_db.responsible_employee (id, employee_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE oleshchuk_db.responsible_employee SET employee_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oleshchuk_db.responsible_employee WHERE id=?";

    @Override
    public List<ResponsibleEmployee> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<ResponsibleEmployee> responsibleEmployees = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer employeeId = resultSet.getInt(2);
                    responsibleEmployees.add(new ResponsibleEmployee(id, employeeId));
                }
            }
        }
        return responsibleEmployees;
    }

    @Override
    public ResponsibleEmployee getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        ResponsibleEmployee responsibleEmployee = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer employeeId = resultSet.getInt(2);
                    responsibleEmployee = new ResponsibleEmployee(foundId, employeeId);
                }
            }
        }

        return responsibleEmployee;
    }

    @Override
    public int create(ResponsibleEmployee entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getEmployeeId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(ResponsibleEmployee entity) throws SQLException {
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
