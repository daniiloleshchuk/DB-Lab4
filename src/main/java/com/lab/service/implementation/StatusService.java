package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.DAO.implementation.StatusDAO;
import com.lab.model.implementation.Status;

public class StatusService extends GeneralService<Status> {
    private final GeneralDAO<Status> STATUS_DAO = new StatusDAO();

    @Override
    public IGeneralDAO<Status> getDAO() {
        return STATUS_DAO;
    }
}
