package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.DAO.implementation.WorkingPositionDAO;
import com.lab.model.implementation.WorkingPosition;

public class WorkingPositionService extends GeneralService<WorkingPosition> {
    private final GeneralDAO<WorkingPosition> WORKING_POSITION_DAO = new WorkingPositionDAO();

    @Override
    public IGeneralDAO<WorkingPosition> getDAO() {
        return WORKING_POSITION_DAO;
    }
}
