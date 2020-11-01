package com.lab.controller.implementation;

import com.lab.model.implementation.Priority;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.PriorityService;

public class PriorityController extends GeneralController<Priority> {

    public static PriorityService priorityService = new PriorityService();

    @Override
    public GeneralService<Priority> getService() {
        return priorityService;
    }
}
