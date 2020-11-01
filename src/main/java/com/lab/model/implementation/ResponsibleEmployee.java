package com.lab.model.implementation;

import com.lab.model.GeneralModelInterface;

public class ResponsibleEmployee implements GeneralModelInterface {
    private Integer id;
    private Integer employeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public ResponsibleEmployee(Integer id, Integer employeeId) {
        this.id = id;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "ResponsibleEmployee{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                '}';
    }
}
