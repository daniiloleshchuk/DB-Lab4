package com.lab.controller.implementation;

import com.lab.model.implementation.TypeOfStatement;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.GeneralService;
import com.lab.service.implementation.TypeOfStatementService;

public class TypeOfStatementController extends GeneralController<TypeOfStatement> {
    private final GeneralService<TypeOfStatement> typeOfStatementService = new TypeOfStatementService();

    @Override
    public final IGeneralService<TypeOfStatement> getService() {
        return typeOfStatementService;
    }
}
