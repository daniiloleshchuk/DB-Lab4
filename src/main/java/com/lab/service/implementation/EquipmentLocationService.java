package com.lab.service.implementation;

import com.lab.DAO.IGeneralDAO;
import com.lab.DAO.implementation.EquipmentLocationDAO;
import com.lab.DAO.implementation.GeneralDAO;
import com.lab.model.implementation.EquipmentLocation;

public class EquipmentLocationService extends GeneralService<EquipmentLocation> {
    private final GeneralDAO<EquipmentLocation> EQUIPMENT_LOCATION_DAO = new EquipmentLocationDAO();

    @Override
    public IGeneralDAO<EquipmentLocation> getDAO() {
        return EQUIPMENT_LOCATION_DAO;
    }
}
