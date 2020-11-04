package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.DAO.implementation.TypeOfStatementDAO;
import com.lab.model.implementation.TypeOfStatement;

public class TypeOfStatementService extends GeneralService<TypeOfStatement> {
    private final GeneralDAO<TypeOfStatement> TYPE_OF_STATEMENT_DAO = new TypeOfStatementDAO();

    @Override
    public IGeneralDAO<TypeOfStatement> getDAO() {
        return TYPE_OF_STATEMENT_DAO;
    }
}
