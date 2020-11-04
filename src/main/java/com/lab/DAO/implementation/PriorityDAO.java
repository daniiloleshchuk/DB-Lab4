package com.lab.DAO.implementation;

import com.lab.model.implementation.Priority;

public class PriorityDAO extends GeneralDAO<Priority> {
    @Override
    public final Class<Priority> getClazz() {
        return Priority.class;
    }
}
