package com.lab.service.implementation;

import com.lab.DAO.GeneralDAOInterface;
import com.lab.DAO.implementation.EquipmentLocationDAO;
import com.lab.model.implementation.EquipmentLocation;

public class EquipmentLocationService extends GeneralService<EquipmentLocation> {
    public GeneralDAOInterface<EquipmentLocation, Integer> equipmentLocationDAOImplementation = new EquipmentLocationDAO();

    @Override
    public GeneralDAOInterface<EquipmentLocation, Integer> getDAO() {
        return equipmentLocationDAOImplementation;
    }
}
