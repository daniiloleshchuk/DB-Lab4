package com.lab.DAO.implementation;

import com.lab.model.implementation.WorkingPosition;

public class WorkingPositionDAO extends GeneralDAO<WorkingPosition> {
    @Override
    public final Class<WorkingPosition> getClazz() {
        return WorkingPosition.class;
    }
}
