package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee implements IGeneralModel {
    private Integer id;
    private String name;
    private String surname;
    private WorkingPosition workingPositionByWorkingPositionId;

    public Employee() {
    }

    public Employee(final Integer id, final String name, final String surname, final WorkingPosition workingPositionByWorkingPositionId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workingPositionByWorkingPositionId = workingPositionByWorkingPositionId;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @ManyToOne
    @JoinColumn(name = "working_position_id", referencedColumnName = "id", nullable = false)
    public WorkingPosition getWorkingPositionByWorkingPositionId() {
        return workingPositionByWorkingPositionId;
    }

    public void setWorkingPositionByWorkingPositionId(WorkingPosition workingPositionByWorkingPositionId) {
        this.workingPositionByWorkingPositionId = workingPositionByWorkingPositionId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", workingPositionByWorkingPositionId=" + workingPositionByWorkingPositionId.getName() +
                '}';
    }
}
