package com.online.store.service.item;

import com.online.store.models.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert ItemDto to Item
     *
     * @param itemDto a ItemDto
     * @return a Item entity
     */
    public Item toModel(ItemDto itemDto) {
        return modelMapper.map(itemDto, Item.class);
    }

    /**
     * Convert Item to ItemDto
     *
     * @param item a Item
     * @return a ItemDto entity
     */
    public ItemDto toDto(Item item) {
        return modelMapper.map(item, ItemDto.class);
    }
}
