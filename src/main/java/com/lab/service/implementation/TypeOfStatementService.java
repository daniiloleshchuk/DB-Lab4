package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.TypeOfStatementDAO;
import com.lab.model.implementation.TypeOfStatement;

public class TypeOfStatementService extends GeneralService<TypeOfStatement> {

    private final IGeneralDAO<TypeOfStatement, Integer> typeOfStatementDAO = new TypeOfStatementDAO();

    @Override
    public final IGeneralDAO<TypeOfStatement, Integer> getDAO() {
        return typeOfStatementDAO;
    }
}
