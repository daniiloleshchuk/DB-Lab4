package com.lab.controller.implementation;

import com.lab.model.implementation.TypeOfStatement;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.TypeOfStatementService;

public class TypeOfStatementController extends GeneralController<TypeOfStatement> {

    private static final TypeOfStatementService TYPE_OF_STATEMENT_SERVICE = new TypeOfStatementService();

    @Override
    public  final GeneralService<TypeOfStatement> getService() {
        return TYPE_OF_STATEMENT_SERVICE;
    }
}
