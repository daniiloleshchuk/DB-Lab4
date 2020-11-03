package com.lab.controller.implementation;

import com.lab.model.implementation.Statement;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.StatementService;

public class StatementController extends GeneralController<Statement> {

    private static final StatementService STATEMENT_SERVICE = new StatementService();

    @Override
    public final GeneralService<Statement> getService() {
        return STATEMENT_SERVICE;
    }
}
