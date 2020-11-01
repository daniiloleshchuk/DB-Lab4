package com.lab.model.implementation;

import com.lab.model.GeneralModelInterface;

public class TypeOfStatement implements GeneralModelInterface {
    private Integer id;
    private String name;

    public TypeOfStatement(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
