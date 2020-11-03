package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.EquipmentLocationDAO;
import com.lab.model.implementation.EquipmentLocation;

public class EquipmentLocationService extends GeneralService<EquipmentLocation> {
    private final IGeneralDAO<EquipmentLocation, Integer> equipmentLocationDAOImplementation = new EquipmentLocationDAO();

    @Override
    public final IGeneralDAO<EquipmentLocation, Integer> getDAO() {
        return equipmentLocationDAOImplementation;
    }
}
