package com.lab.model.implementation;

import com.lab.model.GeneralModelInterface;

public class InitiatingEmployee implements GeneralModelInterface {
    private Integer id;
    private Integer employeeId;

    @Override
    public String toString() {
        return "InitiatingEmployee{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                '}';
    }

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

    public InitiatingEmployee(Integer id, Integer employeeId) {
        this.id = id;
        this.employeeId = employeeId;
    }
}
