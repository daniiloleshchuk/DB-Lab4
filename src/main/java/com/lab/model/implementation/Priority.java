package com.lab.model.implementation;

import com.lab.model.GeneralModelInterface;

public class Priority implements GeneralModelInterface {
    private Integer id;
    private String level;

    public Priority(Integer id, String level) {
        this.id = id;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", level='" + level + '\'' +
                '}';
    }
}
