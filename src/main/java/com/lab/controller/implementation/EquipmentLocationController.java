package com.lab.controller.implementation;

import com.lab.model.implementation.EquipmentLocation;
import com.lab.service.IGeneralService;
import com.lab.service.implementation.EquipmentLocationService;
import com.lab.service.implementation.GeneralService;

public class EquipmentLocationController extends GeneralController<EquipmentLocation> {
    private final GeneralService<EquipmentLocation> equipmentLocationService = new EquipmentLocationService();

    @Override
    public final IGeneralService<EquipmentLocation> getService() {
        return equipmentLocationService;
    }
}
