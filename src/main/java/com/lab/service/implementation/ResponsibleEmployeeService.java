package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.DAO.implementation.ResponsibleEmployeeDAO;
import com.lab.model.implementation.ResponsibleEmployee;

public class ResponsibleEmployeeService extends GeneralService<ResponsibleEmployee> {
    private final GeneralDAO<ResponsibleEmployee> RESPONSIBLE_EMPLOYEE_DAO = new ResponsibleEmployeeDAO();

    @Override
    public IGeneralDAO<ResponsibleEmployee> getDAO() {
        return RESPONSIBLE_EMPLOYEE_DAO;
    }
}
