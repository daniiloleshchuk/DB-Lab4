package com.lab.controller;

import com.lab.service.IGeneralService;
import org.hibernate.Session;

import java.sql.SQLException;

public interface IGeneralController<T> {
    void create(T entity, Session session) throws SQLException;

    void update(T entity, Session session) throws SQLException;

    void delete(int id, Session session) throws SQLException;

    void getAll(Session session) throws SQLException;

    void getById(int id, Session session) throws SQLException;

    IGeneralService<T> getService();
}
