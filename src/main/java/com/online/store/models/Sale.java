package com.online.store.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Sale extends ModelBase {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sale", cascade = CascadeType.ALL)
    private Set<SaleDetail> saleDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    private Double totalPrice;

    private Double totalImport;

    private Double totalImportPrice;

    public Set<SaleDetail> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(Set<SaleDetail> saleDetails) {
        this.saleDetails = saleDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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
