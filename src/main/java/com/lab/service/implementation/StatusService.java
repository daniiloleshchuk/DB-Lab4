package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.StatusDAO;
import com.lab.model.implementation.Status;

public class StatusService extends GeneralService<Status> {

    private final IGeneralDAO<Status, Integer> statusDAO = new StatusDAO();

    @Override
    public final IGeneralDAO<Status, Integer> getDAO() {
        return statusDAO;
    }
}
