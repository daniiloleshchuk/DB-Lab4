package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.DAO.implementation.InitiatingEmployeeDAO;
import com.lab.model.implementation.InitiatingEmployee;

public class InitiatingEmployeeService extends GeneralService<InitiatingEmployee> {
    private final GeneralDAO<InitiatingEmployee> INITIATING_EMPLOYEE_DAO = new InitiatingEmployeeDAO();

    @Override
    public IGeneralDAO<InitiatingEmployee> getDAO() {
        return INITIATING_EMPLOYEE_DAO;
    }
}
