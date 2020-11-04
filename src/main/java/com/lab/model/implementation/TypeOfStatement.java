package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_of_statement", schema = "oleshchuk_db", catalog = "")
public class TypeOfStatement implements IGeneralModel {
    private static final String tableName = TypeOfStatement.class.getSimpleName();
    private Integer id;
    private String name;

    public TypeOfStatement() {
    }

    public TypeOfStatement(Integer id, String name) {
        this.id = id;
        this.name = name;
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
        TypeOfStatement that = (TypeOfStatement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TypeOfStatement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
