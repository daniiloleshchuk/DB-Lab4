package com.lab.controller.implementation;

import com.lab.model.implementation.TypeOfStatement;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.TypeOfStatementService;

public class TypeOfStatementController extends GeneralController<TypeOfStatement> {

    public static TypeOfStatementService typeOfStatementService = new TypeOfStatementService();

    @Override
    public GeneralService<TypeOfStatement> getService() {
        return typeOfStatementService;
    }
}
