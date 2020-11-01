package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.InitiatingEmployeeDAO;
import com.lab.model.implementation.InitiatingEmployee;

public class InitiatingEmployeeService extends GeneralService<InitiatingEmployee> {

    public GeneralDAOInterface<InitiatingEmployee, Integer> initiatingEmployeeDAO = new InitiatingEmployeeDAO();

    @Override
    public GeneralDAOInterface<InitiatingEmployee, Integer> getDAO() {
        return initiatingEmployeeDAO;
    }
}
