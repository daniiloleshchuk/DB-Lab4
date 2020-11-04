package com.lab.controller.implementation;

import com.lab.model.implementation.Statement;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.StatementService;

public class StatementController extends GeneralController<Statement> {
    private final GeneralService<Statement> statementService = new StatementService();

    @Override
    public final IGeneralService<Statement> getService() {
        return statementService;
    }
}
