package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.PriorityDAO;
import com.lab.model.implementation.Priority;

public class PriorityService extends GeneralService<Priority> {

    private final IGeneralDAO<Priority, Integer> priorityDAO = new PriorityDAO();

    @Override
    public final IGeneralDAO<Priority, Integer> getDAO() {
        return priorityDAO;
    }
}
