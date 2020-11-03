package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.InitiatingEmployeeDAO;
import com.lab.model.implementation.InitiatingEmployee;

public class InitiatingEmployeeService extends GeneralService<InitiatingEmployee> {

    private final IGeneralDAO<InitiatingEmployee, Integer> initiatingEmployeeDAO = new InitiatingEmployeeDAO();

    @Override
    public final IGeneralDAO<InitiatingEmployee, Integer> getDAO() {
        return initiatingEmployeeDAO;
    }
}
