package com.online.store.service.inventory;

import com.online.store.service.BaseDto;

public class InventoryDto extends BaseDto {

    private Integer quantity;

    private Long itemId;

    private Long inventoryStateId;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getInventoryStateId() {
        return inventoryStateId;
    }

    public void setInventoryStateId(Long inventoryStateId) {
        this.inventoryStateId = inventoryStateId;
    }
}
