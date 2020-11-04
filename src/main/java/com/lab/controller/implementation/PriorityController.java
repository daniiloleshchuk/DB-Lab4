package com.lab.controller.implementation;

import com.lab.model.implementation.Priority;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.PriorityService;

public class PriorityController extends GeneralController<Priority> {
    private final GeneralService<Priority> priorityService = new PriorityService();

    @Override
    public final IGeneralService<Priority> getService() {
        return priorityService;
    }
}
