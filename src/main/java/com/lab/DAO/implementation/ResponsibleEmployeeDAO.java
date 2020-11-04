package com.lab.DAO.implementation;

import com.lab.model.implementation.ResponsibleEmployee;

public class ResponsibleEmployeeDAO extends GeneralDAO<ResponsibleEmployee> {
    @Override
    public final Class<ResponsibleEmployee> getClazz() {
        return ResponsibleEmployee.class;
    }
}
