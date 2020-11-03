package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

public class Employee implements IGeneralModel {
    private Integer id;
    private String name;
    private String surname;
    private Integer workingPositionId;

    public Employee(final Integer id, final String name, final String surname, final Integer workingPositionId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workingPositionId = workingPositionId;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getSurname() {
        return surname;
    }

    public final void setSurname(final String surname) {
        this.surname = surname;
    }

    public final Integer getWorkingPositionId() {
        return workingPositionId;
    }

    public final void setWorkingPositionId(final Integer workingPositionId) {
        this.workingPositionId = workingPositionId;
    }

    @Override
    public final String toString() {
        return "Employee{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", workingPositionId='" + workingPositionId + '\''
                + '}';
    }
}
