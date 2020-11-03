package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

public class TypeOfStatement implements IGeneralModel {
    private Integer id;
    private String name;

    public TypeOfStatement(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return "TypeOfStatement{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
