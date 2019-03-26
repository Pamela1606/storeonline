package com.online.store.service.sale;

import com.online.store.service.BaseDto;

public class SaleDto extends BaseDto {

    private Double totalPrice;

    private Double totalImport;

    private Double totalImportPrice;

    private Long customerId;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
