package com.online.store.service.item;

import com.online.store.models.ItemImage;
import com.online.store.service.BaseDto;

import java.util.List;

public class ItemDto extends BaseDto {

    private String name;

    private String description;

    private Double price;

    private Double tax;

    private Double importPrice;

    private Long modelItemId;

    private Long categoryId;

    private String capacity;

    private Long brandId;

    private List<ItemImage> itemImages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Double importPrice) {
        this.importPrice = importPrice;
    }

    public Long getModelItemId() {
        return modelItemId;
    }

    public void setModelItemId(Long modelItemId) {
        this.modelItemId = modelItemId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public List<ItemImage> getItemImages() {
        return itemImages;
    }

    public void setItemImages(List<ItemImage> itemImages) {
        this.itemImages = itemImages;
    }
}
