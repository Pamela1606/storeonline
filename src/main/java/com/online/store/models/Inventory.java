package com.online.store.models;

import javax.persistence.Entity;

@Entity
public class Inventory extends ModelBase {

    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
