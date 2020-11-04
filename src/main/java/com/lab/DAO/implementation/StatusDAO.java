package com.lab.DAO.implementation;

import com.lab.model.implementation.Status;

public class StatusDAO extends GeneralDAO<Status> {
    @Override
    public final Class<Status> getClazz() {
        return Status.class;
    }
}
