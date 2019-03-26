package com.online.store.service.itemImage;

import com.online.store.service.BaseDto;

public class ItemImageDto extends BaseDto {

    private String url;

    private Long itemId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
