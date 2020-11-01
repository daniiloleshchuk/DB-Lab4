package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.ResponsibleEmployeeDAO;
import com.lab.model.implementation.ResponsibleEmployee;

public class ResponsibleEmployeeService extends GeneralService<ResponsibleEmployee> {

    public GeneralDAOInterface<ResponsibleEmployee, Integer> responsibleEmployeeDAO = new ResponsibleEmployeeDAO();

    @Override
    public GeneralDAOInterface<ResponsibleEmployee, Integer> getDAO() {
        return responsibleEmployeeDAO;
    }
}
