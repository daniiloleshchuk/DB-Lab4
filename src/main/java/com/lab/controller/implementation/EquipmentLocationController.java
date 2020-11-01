package com.lab.controller.implementation;

import com.lab.model.implementation.EquipmentLocation;
import com.lab.service.implementation.EquipmentLocationService;
import com.lab.service.implementation.GeneralService;

public class EquipmentLocationController extends GeneralController<EquipmentLocation> {

    public static EquipmentLocationService equipmentLocationService = new EquipmentLocationService();

    @Override
    public GeneralService<EquipmentLocation> getService() {
        return equipmentLocationService;
    }
}
