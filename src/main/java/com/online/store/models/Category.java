package com.online.store.models;

import javax.persistence.Entity;

@Entity
public class Category extends ModelBase {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
