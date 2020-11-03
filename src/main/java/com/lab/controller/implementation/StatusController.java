package com.lab.controller.implementation;

import com.lab.model.implementation.Status;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.StatusService;

public class StatusController extends GeneralController<Status> {

    private static final StatusService STATUS_SERVICE = new StatusService();

    @Override
    public final GeneralService<Status> getService() {
        return STATUS_SERVICE;
    }
}
