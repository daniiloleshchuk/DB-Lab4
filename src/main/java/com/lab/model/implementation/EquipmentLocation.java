package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

public class EquipmentLocation implements IGeneralModel {
    private Integer id;
    private String office;
    private Integer roomNumber;
    private Integer workingPlaceNumber;

    public EquipmentLocation(final Integer id, final String office, final Integer roomNumber,
                             final Integer workingPlaceNumber) {
        this.id = id;
        this.office = office;
        this.roomNumber = roomNumber;
        this.workingPlaceNumber = workingPlaceNumber;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(Integer id) {
        this.id = id;
    }

    public final String getOffice() {
        return office;
    }

    public final void setOffice(String office) {
        this.office = office;
    }

    public final Integer getRoomNumber() {
        return roomNumber;
    }

    public final void setRoomNumber(final Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public final Integer getWorkingPlaceNumber() {
        return workingPlaceNumber;
    }

    public final void setWorkingPlaceNumber(final Integer workingPlaceNumber) {
        this.workingPlaceNumber = workingPlaceNumber;
    }

    @Override
    public final String toString() {
        return "EquipmentLocation{"
                + "id=" + id
                + ", office='" + office + '\''
                + ", roomNumber=" + roomNumber
                + ", workingPlaceNumber=" + workingPlaceNumber
                + '}';
    }
}
