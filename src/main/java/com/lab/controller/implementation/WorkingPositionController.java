package com.lab.controller.implementation;

import com.lab.model.implementation.WorkingPosition;
import com.lab.service.implementation.EmployeeService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.WorkingPositionService;

public class WorkingPositionController extends GeneralController<WorkingPosition> {

    public static WorkingPositionService workingPositionService = new WorkingPositionService();

    @Override
    public GeneralService<WorkingPosition> getService() {
        return workingPositionService;
    }
}
