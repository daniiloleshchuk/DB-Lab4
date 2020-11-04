package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipment_location", schema = "oleshchuk_db", catalog = "")
public class EquipmentLocation implements IGeneralModel {
    private static final String tableName = EquipmentLocation.class.getSimpleName();
    private Integer id;
    private String office;
    private Integer roomNumber;
    private Integer workingPlaceNumber;

    public EquipmentLocation() {
    }

    public EquipmentLocation(final Integer id, final String office, final Integer roomNumber,
                             final Integer workingPlaceNumber) {
        this.id = id;
        this.office = office;
        this.roomNumber = roomNumber;
        this.workingPlaceNumber = workingPlaceNumber;
    }

    public static String getTableName() {
        return tableName;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "office")
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Basic
    @Column(name = "room_number")
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "working_place_number")
    public Integer getWorkingPlaceNumber() {
        return workingPlaceNumber;
    }

    public void setWorkingPlaceNumber(Integer workingPlaceNumber) {
        this.workingPlaceNumber = workingPlaceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentLocation that = (EquipmentLocation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(office, that.office) &&
                Objects.equals(roomNumber, that.roomNumber) &&
                Objects.equals(workingPlaceNumber, that.workingPlaceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, office, roomNumber, workingPlaceNumber);
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
