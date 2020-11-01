package com.lab.model.implementation;

import com.lab.model.GeneralModelInterface;

public class Employee implements GeneralModelInterface {
    private Integer id;
    private String name;
    private String surname;
    private Integer workingPositionId;

    public Employee(Integer id, String name, String surname, Integer workingPositionId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workingPositionId = workingPositionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getWorkingPositionId() {
        return workingPositionId;
    }

    public void setWorkingPositionId(Integer workingPositionId) {
        this.workingPositionId = workingPositionId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", workingPositionId='" + workingPositionId + '\'' +
                '}';
    }
}
