package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.ResponsibleEmployeeDAO;
import com.lab.model.implementation.ResponsibleEmployee;

public class ResponsibleEmployeeService extends GeneralService<ResponsibleEmployee> {

    private final IGeneralDAO<ResponsibleEmployee, Integer> responsibleEmployeeDAO = new ResponsibleEmployeeDAO();

    @Override
    public final IGeneralDAO<ResponsibleEmployee, Integer> getDAO() {
        return responsibleEmployeeDAO;
    }
}
