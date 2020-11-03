package com.lab.controller.implementation;

import com.lab.model.implementation.Employee;
import com.lab.service.implementation.EmployeeService;
import com.lab.service.implementation.GeneralService;

public class EmployeeController extends GeneralController<Employee> {

    private static final EmployeeService EMPLOYEE_SERVICE = new EmployeeService();

    @Override
    public final GeneralService<Employee> getService() {
        return EMPLOYEE_SERVICE;
    }

}
