package com.lab.controller.implementation;

import com.lab.model.implementation.Status;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.StatusService;

public class StatusController extends GeneralController<Status> {
    private final GeneralService<Status> statusService = new StatusService();

    @Override
    public final IGeneralService<Status> getService() {
        return statusService;
    }
}
