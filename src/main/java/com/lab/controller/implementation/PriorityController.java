package com.lab.controller.implementation;

import com.lab.model.implementation.Priority;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.PriorityService;

public class PriorityController extends GeneralController<Priority> {

    private static final PriorityService PRIORITY_SERVICE = new PriorityService();

    @Override
    public final GeneralService<Priority> getService() {
        return PRIORITY_SERVICE;
    }
}
