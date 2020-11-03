package com.lab.controller.implementation;

import com.lab.model.implementation.InitiatingEmployee;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.InitiatingEmployeeService;

public class InitiatingEmployeeController extends GeneralController<InitiatingEmployee> {

    private static final InitiatingEmployeeService INITIATING_EMPLOYEE_SERVICE = new InitiatingEmployeeService();

    @Override
    public final GeneralService<InitiatingEmployee> getService() {
        return INITIATING_EMPLOYEE_SERVICE;
    }
}
