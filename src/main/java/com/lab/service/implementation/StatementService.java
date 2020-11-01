package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.StatementDAO;
import com.lab.model.implementation.Statement;

public class StatementService extends GeneralService<Statement> {

    public GeneralDAOInterface<Statement, Integer> statementDAO = new StatementDAO();

    @Override
    public GeneralDAOInterface<Statement, Integer> getDAO() {
        return statementDAO;
    }
}
