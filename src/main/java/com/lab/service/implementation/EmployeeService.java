package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.EmployeeDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.model.implementation.Employee;

public class EmployeeService extends GeneralService<Employee> {
    private final GeneralDAO<Employee> EMPLOYEE_DAO = new EmployeeDAO();

    @Override
    public IGeneralDAO<Employee> getDAO() {
        return EMPLOYEE_DAO;
    }
}
