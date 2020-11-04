package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "responsible_employee", schema = "oleshchuk_db", catalog = "")
public class ResponsibleEmployee implements IGeneralModel {
    private static final String tableName = ResponsibleEmployee.class.getSimpleName();
    private Integer id;
    private Employee employeeByEmployeeId;

    public ResponsibleEmployee() {
    }

    public ResponsibleEmployee(final Integer id, final Employee employeeByEmployeeId) {
        this.id = id;
        this.employeeByEmployeeId = employeeByEmployeeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsibleEmployee that = (ResponsibleEmployee) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @Override
    public String toString() {
        return "ResponsibleEmployee{" +
                "id=" + id +
                ", employeeByEmployeeId=" + employeeByEmployeeId +
                '}';
    }
}
