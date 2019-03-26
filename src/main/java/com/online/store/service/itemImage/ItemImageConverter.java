package com.online.store.service.itemImage;

import com.online.store.models.ItemImage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemImageConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert ItemImageDto to ItemImage
     *
     * @param itemImageDto a ItemImageDto
     * @return a ItemImage entity
     */
    public ItemImage toModel(ItemImageDto itemImageDto) {
        return modelMapper.map(itemImageDto, ItemImage.class);
    }

    /**
     * Convert ItemImage to ItemImageDto
     *
     * @param itemImage a ItemImage
     * @return a CategoryDto entity
     */
    public ItemImageDto toDto(ItemImage itemImage) {
        return modelMapper.map(itemImage, ItemImageDto.class);
    }
}
