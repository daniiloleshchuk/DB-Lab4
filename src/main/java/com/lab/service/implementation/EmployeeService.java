package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.EmployeeDAO;
import com.lab.model.implementation.Employee;

public class EmployeeService extends GeneralService<Employee> {
    private final IGeneralDAO<Employee, Integer> employeeDAOImplementation = new EmployeeDAO();

    @Override
    public final IGeneralDAO<Employee, Integer> getDAO() {
        return employeeDAOImplementation;
    }
}
