package com.online.store.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class InventoryState extends ModelBase {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryState", cascade = CascadeType.ALL)
    private Set<Inventory> inventories;

    private String name;

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
