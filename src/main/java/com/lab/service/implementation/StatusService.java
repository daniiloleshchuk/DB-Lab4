package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.EmployeeDAO;
import com.lab.DAO.implementation.StatusDAO;
import com.lab.model.implementation.Employee;
import com.lab.model.implementation.Status;

public class StatusService extends GeneralService<Status> {

    public GeneralDAOInterface<Status, Integer> statusDAO = new StatusDAO();

    @Override
    public GeneralDAOInterface<Status, Integer> getDAO() {
        return statusDAO;
    }
}
