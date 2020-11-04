package com.lab.controller.implementation;

import com.lab.model.implementation.InitiatingEmployee;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.InitiatingEmployeeService;

public class InitiatingEmployeeController extends GeneralController<InitiatingEmployee> {
    private final GeneralService<InitiatingEmployee> initiatingEmployeeService = new InitiatingEmployeeService();

    @Override
    public final IGeneralService<InitiatingEmployee> getService() {
        return initiatingEmployeeService;
    }
}
