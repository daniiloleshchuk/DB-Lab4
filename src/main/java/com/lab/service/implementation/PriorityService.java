package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.DAO.implementation.PriorityDAO;
import com.lab.model.implementation.Priority;

public class PriorityService extends GeneralService<Priority> {
    private final GeneralDAO<Priority> PRIORITY_DAO = new PriorityDAO();

    @Override
    public IGeneralDAO<Priority> getDAO() {
        return PRIORITY_DAO;
    }
}
