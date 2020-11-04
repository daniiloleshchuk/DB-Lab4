package com.lab.controller.implementation;

import com.lab.model.implementation.Employee;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.EmployeeService;
import com.lab.service.implementation.GeneralService;

public class EmployeeController extends GeneralController<Employee> {
    private final GeneralService<Employee> employeeService = new EmployeeService();

    @Override
    public final IGeneralService<Employee> getService() {
        return employeeService;
    }
}
