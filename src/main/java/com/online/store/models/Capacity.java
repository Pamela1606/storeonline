package com.online.store.models;

import javax.persistence.Entity;

@Entity
public class Capacity extends ModelBase {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
