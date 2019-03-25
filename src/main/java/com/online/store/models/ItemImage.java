package com.online.store.models;

import javax.persistence.Entity;

@Entity
public class ItemImage extends ModelBase {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
