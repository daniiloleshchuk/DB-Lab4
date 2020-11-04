package com.lab.DAO.implementation;

import com.lab.model.implementation.Statement;

public class StatementDAO extends GeneralDAO<Statement> {
    @Override
    public final Class<Statement> getClazz() {
        return Statement.class;
    }
}
