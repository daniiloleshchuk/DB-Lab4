package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

public class Priority implements IGeneralModel {
    private Integer id;
    private String level;

    public Priority(final Integer id, final String level) {
        this.id = id;
        this.level = level;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getLevel() {
        return level;
    }

    public final void setLevel(final String level) {
        this.level = level;
    }

    @Override
    public final String toString() {
        return "Priority{"
                + "id=" + id
                + ", level='" + level + '\''
                + '}';
    }
}
