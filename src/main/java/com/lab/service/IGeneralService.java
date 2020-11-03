package com.lab.service;

import com.lab.DAO.GeneralDAOInterface;

import java.sql.SQLException;
import java.util.List;

public interface GeneralServiceInterface<T> {
    public GeneralDAOInterface<T, Integer> getDAO();

    public List<T> getAll() throws SQLException;
    public T getById(Integer id) throws SQLException;
    public int create(T entity) throws SQLException;
    public int update(T entity) throws SQLException;
    public int delete(Integer id) throws SQLException;


}
