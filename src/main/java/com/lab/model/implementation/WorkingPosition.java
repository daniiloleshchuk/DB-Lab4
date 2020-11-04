package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "working_position", schema = "oleshchuk_db", catalog = "")
public class WorkingPosition implements IGeneralModel {
    private static final String tableName = WorkingPosition.class.getSimpleName();
    private Integer id;
    private String name;
    private Collection<Employee> employeesById;

    public WorkingPosition() {
    }

    public WorkingPosition(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public WorkingPosition(Integer id, String name, Collection<Employee> employeesById) {
        this.id = id;
        this.name = name;
        this.employeesById = employeesById;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingPosition that = (WorkingPosition) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "workingPositionByWorkingPositionId")
    public Collection<Employee> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<Employee> employeesById) {
        this.employeesById = employeesById;
    }

    @Override
    public String toString() {
        return "WorkingPosition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeesById=" + employeesById +
                '}';
    }
}
