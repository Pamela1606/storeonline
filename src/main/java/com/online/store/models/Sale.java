package com.online.store.models;

import javax.persistence.Entity;

@Entity
public class Sale extends ModelBase {

    private Double totalPrice;

    private Double totalImport;

    private Double totalImportPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalImport() {
        return totalImport;
    }

    public void setTotalImport(Double totalImport) {
        this.totalImport = totalImport;
    }

    public Double getTotalImportPrice() {
        return totalImportPrice;
    }

    public void setTotalImportPrice(Double totalImportPrice) {
        this.totalImportPrice = totalImportPrice;
    }
}
