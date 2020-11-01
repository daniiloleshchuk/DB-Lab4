package com.lab.model.implementation;

import com.lab.model.GeneralModelInterface;

public class EquipmentLocation implements GeneralModelInterface {
    private Integer id;
    private String office;
    private Integer roomNumber;
    private Integer workingPlaceNumber;

    public EquipmentLocation(Integer id, String office, Integer roomNumber, Integer workingPlaceNumber) {
        this.id = id;
        this.office = office;
        this.roomNumber = roomNumber;
        this.workingPlaceNumber = workingPlaceNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getWorkingPlaceNumber() {
        return workingPlaceNumber;
    }

    public void setWorkingPlaceNumber(Integer workingPlaceNumber) {
        this.workingPlaceNumber = workingPlaceNumber;
    }

    @Override
    public String toString() {
        return "EquipmentLocation{" +
                "id=" + id +
                ", office='" + office + '\'' +
                ", roomNumber=" + roomNumber +
                ", workingPlaceNumber=" + workingPlaceNumber +
                '}';
    }
}
