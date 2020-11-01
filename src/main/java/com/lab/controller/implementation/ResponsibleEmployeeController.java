package com.lab.controller.implementation;

import com.lab.model.implementation.ResponsibleEmployee;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.ResponsibleEmployeeService;

public class ResponsibleEmployeeController extends GeneralController<ResponsibleEmployee> {

    public static ResponsibleEmployeeService responsibleEmployeeService = new ResponsibleEmployeeService();


    @Override
    public GeneralService<ResponsibleEmployee> getService() {
        return responsibleEmployeeService;
    }
}
