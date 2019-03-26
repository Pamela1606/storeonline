package com.online.store.service.saleDetail;

import com.online.store.service.BaseDto;

public class SaleDetailDto extends BaseDto {

    private Integer quantity;

    private Long itemId;

    private Long saleId;

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

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
