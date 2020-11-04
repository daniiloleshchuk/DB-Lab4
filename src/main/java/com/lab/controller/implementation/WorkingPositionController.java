package com.lab.controller.implementation;

import com.lab.model.implementation.WorkingPosition;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.WorkingPositionService;

public class WorkingPositionController extends GeneralController<WorkingPosition> {
    private final GeneralService<WorkingPosition> workingPositionService = new WorkingPositionService();

    @Override
    public final IGeneralService<WorkingPosition> getService() {
        return workingPositionService;
    }
}
