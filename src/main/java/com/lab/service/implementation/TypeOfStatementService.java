package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.TypeOfStatementDAO;
import com.lab.model.implementation.TypeOfStatement;

public class TypeOfStatementService extends GeneralService<TypeOfStatement> {

    public GeneralDAOInterface<TypeOfStatement, Integer> typeOfStatementDAO = new TypeOfStatementDAO();

    @Override
    public GeneralDAOInterface<TypeOfStatement, Integer> getDAO() {
        return typeOfStatementDAO;
    }
}
