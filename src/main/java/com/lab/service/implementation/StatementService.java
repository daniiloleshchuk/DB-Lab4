package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.StatementDAO;
import com.lab.model.implementation.Statement;

public class StatementService extends GeneralService<Statement> {

    private final IGeneralDAO<Statement, Integer> statementDAO = new StatementDAO();

    @Override
    public final IGeneralDAO<Statement, Integer> getDAO() {
        return statementDAO;
    }
}
