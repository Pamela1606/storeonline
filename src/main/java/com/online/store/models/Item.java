package com.online.store.models;

import javax.persistence.Entity;

@Entity
public class Item extends ModelBase {

    private String name;

    private String desciption;

    private Double price;

    private Double tags;

    private Double importPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTags() {
        return tags;
    }

    public void setTags(Double tags) {
        this.tags = tags;
    }

    public Double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Double importPrice) {
        this.importPrice = importPrice;
    }
}
