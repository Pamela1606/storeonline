package com.online.store.service.inventory;

import com.online.store.service.BaseDto;

public class InventoryDto extends BaseDto {

    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
