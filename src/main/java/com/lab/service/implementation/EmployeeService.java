package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.EmployeeDAO;
import com.lab.model.implementation.Employee;

public class EmployeeService extends GeneralService<Employee> {
    public GeneralDAOInterface<Employee, Integer> employeeDAOImplementation = new EmployeeDAO();

    @Override
    public GeneralDAOInterface<Employee, Integer> getDAO() {
        return employeeDAOImplementation;
    }

    /*
    public List<Employee> getByName(String name) throws SQLException{
        return employeeDAOImplementation.getByName(name);
    }

    public List<Employee> getBySurname(String surname) throws SQLException{
        return employeeDAOImplementation.getBySurname(surname);
    }

     */
}
