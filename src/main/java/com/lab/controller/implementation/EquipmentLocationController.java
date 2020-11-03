package com.lab.controller.implementation;

import com.lab.model.implementation.EquipmentLocation;
import com.lab.service.implementation.EquipmentLocationService;
import com.lab.service.implementation.GeneralService;

public class EquipmentLocationController extends GeneralController<EquipmentLocation> {

    private static final EquipmentLocationService EQUIPMENT_LOCATION_SERVICE = new EquipmentLocationService();

    @Override
    public final GeneralService<EquipmentLocation> getService() {
        return EQUIPMENT_LOCATION_SERVICE;
    }
}
