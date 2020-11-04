package com.lab.DAO.implementation;

import com.lab.model.implementation.EquipmentLocation;

public class EquipmentLocationDAO extends GeneralDAO<EquipmentLocation> {
    @Override
    public final Class<EquipmentLocation> getClazz() {
        return EquipmentLocation.class;
    }
}
