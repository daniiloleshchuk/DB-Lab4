package com.lab.DAO.implementation;

import com.lab.model.implementation.InitiatingEmployee;

public class InitiatingEmployeeDAO extends GeneralDAO<InitiatingEmployee> {
    @Override
    public final Class<InitiatingEmployee> getClazz() {
        return InitiatingEmployee.class;
    }
}
