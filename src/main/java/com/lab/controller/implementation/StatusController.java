package com.lab.controller.implementation;

import com.lab.model.implementation.Status;
import com.lab.service.implementation.EmployeeService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.StatusService;

public class StatusController extends GeneralController<Status> {

    public static StatusService statusService = new StatusService();

    @Override
    public GeneralService<Status> getService() {
        return statusService;
    }
}
