package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.PriorityDAO;
import com.lab.model.implementation.Priority;

public class PriorityService extends GeneralService<Priority> {

    public GeneralDAOInterface<Priority, Integer> priorityDAO = new PriorityDAO();

    @Override
    public GeneralDAOInterface<Priority, Integer> getDAO() {
        return priorityDAO;
    }
}
