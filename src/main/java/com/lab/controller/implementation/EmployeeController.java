package com.lab.controller.implementation;

import com.lab.model.implementation.Employee;
import com.lab.service.implementation.EmployeeService;
import com.lab.service.implementation.GeneralService;

public class EmployeeController extends GeneralController<Employee> {

    public static EmployeeService employeeService = new EmployeeService();

    @Override
    public GeneralService<Employee> getService() {
        return employeeService;
    }

}
