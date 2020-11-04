package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.DAO.implementation.StatementDAO;
import com.lab.model.implementation.Statement;

public class StatementService extends GeneralService<Statement> {
    private final GeneralDAO<Statement> STATEMENT_DAO = new StatementDAO();

    @Override
    public IGeneralDAO<Statement> getDAO() {
        return STATEMENT_DAO;
    }
}
