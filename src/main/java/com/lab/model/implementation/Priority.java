package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Priority implements IGeneralModel {
    private static final String tableName = Priority.class.getSimpleName();
    private Integer id;
    private String level;

    public Priority() {
    }

    public Priority(final Integer id, final String level) {
        this.id = id;
        this.level = level;
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
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return Objects.equals(id, priority.id) &&
                Objects.equals(level, priority.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level);
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", level='" + level + '\'' +
                '}';
    }

}
