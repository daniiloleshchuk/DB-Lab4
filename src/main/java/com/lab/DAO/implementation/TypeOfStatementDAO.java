package com.lab.DAO.implementation;

import com.lab.model.implementation.TypeOfStatement;

public class TypeOfStatementDAO extends GeneralDAO<TypeOfStatement> {
    @Override
    public final Class<TypeOfStatement> getClazz() {
        return TypeOfStatement.class;
    }
}
