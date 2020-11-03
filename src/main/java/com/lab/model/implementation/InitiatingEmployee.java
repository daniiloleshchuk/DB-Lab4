package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

public class InitiatingEmployee implements IGeneralModel {
    private Integer id;
    private Integer employeeId;

    public InitiatingEmployee(Integer id, Integer employeeId) {
        this.id = id;
        this.employeeId = employeeId;
    }

    @Override
    public final String toString() {
        return "InitiatingEmployee{"
                + "id=" + id
                + ", employeeId=" + employeeId
                + '}';
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final Integer getEmployeeId() {
        return employeeId;
    }

    public final void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }


}
