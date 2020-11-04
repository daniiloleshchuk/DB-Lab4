package com.lab.DAO.implementation;

import com.lab.model.implementation.Employee;

public class EmployeeDAO extends GeneralDAO<Employee> {

    @Override
    public final Class<Employee> getClazz() {
        return Employee.class;
    }

}
