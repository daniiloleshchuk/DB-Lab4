package com.lab.controller.implementation;

import com.lab.model.implementation.WorkingPosition;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.WorkingPositionService;

public class WorkingPositionController extends GeneralController<WorkingPosition> {

    private static final WorkingPositionService WORKING_POSITION_SERVICE = new WorkingPositionService();

    @Override
    public final GeneralService<WorkingPosition> getService() {
        return WORKING_POSITION_SERVICE;
    }
}
