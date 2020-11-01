package com.lab.controller.implementation;

import com.lab.model.implementation.InitiatingEmployee;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.InitiatingEmployeeService;

public class InitiatingEmployeeController extends GeneralController<InitiatingEmployee> {

    public static InitiatingEmployeeService initiatingEmployeeService = new InitiatingEmployeeService();

    @Override
    public GeneralService<InitiatingEmployee> getService() {
        return initiatingEmployeeService;
    }
}
