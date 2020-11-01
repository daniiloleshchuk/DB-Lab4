package com.lab.controller.implementation;

import com.lab.model.implementation.Statement;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.StatementService;

public class StatementController extends GeneralController<Statement> {

    public static StatementService statementService = new StatementService();

    @Override
    public GeneralService<Statement> getService() {
        return statementService;
    }
}
