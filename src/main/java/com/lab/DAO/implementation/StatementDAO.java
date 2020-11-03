package com.lab.DAO.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.model.implementation.Statement;
import com.lab.persistance.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StatementDAO implements IGeneralDAO<Statement, Integer> {

    private static final String GET_ALL = "SELECT * FROM oleshchuk_db.statement";
    private static final String GET_BY_ID = "SELECT * FROM oleshchuk_db.statement WHERE id=?";
    private static final String CREATE = "INSERT oleshchuk_db.statement (id, description, creation_date, "
            + "initiating_employee_id, equipment_location_id, status_id, priority_id, responsible_employee_id, "
            + "type_of_statement_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE oleshchuk_db.statement SET description=?, creation_date=?, "
            + "initiating_employee_id=?, equipment_location_id=?, status_id=?, priority_id=?, "
            + "responsible_employee_id=?, type_of_statement_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM oleshchuk_db.statement WHERE id=?";

    @Override
    public final List<Statement> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Statement> statements = new LinkedList<>();

        try (java.sql.Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    String creationDate = resultSet.getString(3);
                    Integer initiatingEmployeeId = resultSet.getInt(4);
                    Integer equipmentLocationId = resultSet.getInt(5);
                    Integer statusId = resultSet.getInt(6);
                    Integer priorityId = resultSet.getInt(7);
                    Integer responsibleEmployeeId = resultSet.getInt(8);
                    Integer typeOfStatementId = resultSet.getInt(9);
                    statements.add(new Statement(id, description, creationDate, initiatingEmployeeId,
                            equipmentLocationId, statusId, priorityId, responsibleEmployeeId, typeOfStatementId));
                }
            }
        }
        return statements;
    }

    @Override
    public final Statement getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Statement statement = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    String creationDate = resultSet.getString(3);
                    Integer initiatingEmployeeId = resultSet.getInt(4);
                    Integer equipmentLocationId = resultSet.getInt(5);
                    Integer statusId = resultSet.getInt(6);
                    Integer priorityId = resultSet.getInt(7);
                    Integer responsibleEmployeeId = resultSet.getInt(8);
                    Integer typeOfStatementId = resultSet.getInt(9);
                    statement = new Statement(foundId, description, creationDate, initiatingEmployeeId,
                            equipmentLocationId, statusId, priorityId, responsibleEmployeeId, typeOfStatementId);
                }
            }
        }

        return statement;
    }

    @Override
    public final int create(final Statement entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getDescription());
            ps.setString(3, entity.getCreationDate());
            ps.setInt(4, entity.getInitiatingEmployeeId());
            ps.setInt(5, entity.getEquipmentLocationId());
            ps.setInt(6, entity.getStatusId());
            ps.setInt(7, entity.getPriorityId());
            ps.setInt(8, entity.getResponsibleEmployeeId());
            ps.setInt(9, entity.getTypeOfStatementId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Statement entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getDescription());
            ps.setString(2, entity.getCreationDate());
            ps.setInt(3, entity.getInitiatingEmployeeId());
            ps.setInt(4, entity.getEquipmentLocationId());
            ps.setInt(5, entity.getStatusId());
            ps.setInt(6, entity.getPriorityId());
            ps.setInt(7, entity.getResponsibleEmployeeId());
            ps.setInt(8, entity.getTypeOfStatementId());
            ps.setInt(9, entity.getId());
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
