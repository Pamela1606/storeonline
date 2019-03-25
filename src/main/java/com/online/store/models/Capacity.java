package com.online.store.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Capacity extends ModelBase {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "capacity", cascade = CascadeType.ALL)
    private Set<Item> items;

    private String name;

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
