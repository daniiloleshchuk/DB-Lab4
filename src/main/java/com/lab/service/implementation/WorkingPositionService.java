package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.WorkingPositionDAO;
import com.lab.model.implementation.WorkingPosition;

public class WorkingPositionService extends GeneralService<WorkingPosition> {

    private final IGeneralDAO<WorkingPosition, Integer> workingPositionDAO = new WorkingPositionDAO();

    @Override
    public final IGeneralDAO<WorkingPosition, Integer> getDAO() {
        return workingPositionDAO;
    }
}
