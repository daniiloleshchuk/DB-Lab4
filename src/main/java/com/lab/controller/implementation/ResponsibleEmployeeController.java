package com.lab.controller.implementation;

import com.lab.model.implementation.ResponsibleEmployee;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.ResponsibleEmployeeService;

public class ResponsibleEmployeeController extends GeneralController<ResponsibleEmployee> {
    private final GeneralService<ResponsibleEmployee> responsibleEmployeeService = new ResponsibleEmployeeService();

    @Override
    public final IGeneralService<ResponsibleEmployee> getService() {
        return responsibleEmployeeService;
    }
}
