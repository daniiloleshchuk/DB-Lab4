package com.lab.controller.implementation;

import com.lab.model.implementation.ResponsibleEmployee;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.ResponsibleEmployeeService;

public class ResponsibleEmployeeController extends GeneralController<ResponsibleEmployee> {

    private static final ResponsibleEmployeeService RESPONSIBLE_EMPLOYEE_SERVICE = new ResponsibleEmployeeService();


    @Override
    public final GeneralService<ResponsibleEmployee> getService() {
        return RESPONSIBLE_EMPLOYEE_SERVICE;
    }
}
