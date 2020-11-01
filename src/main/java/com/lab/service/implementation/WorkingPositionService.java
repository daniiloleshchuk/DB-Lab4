package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.WorkingPositionDAO;
import com.lab.model.implementation.WorkingPosition;

public class WorkingPositionService extends GeneralService<WorkingPosition> {

    public GeneralDAOInterface<WorkingPosition, Integer> workingPositionDAO = new WorkingPositionDAO();

    @Override
    public GeneralDAOInterface<WorkingPosition, Integer> getDAO() {
        return workingPositionDAO;
    }
}
