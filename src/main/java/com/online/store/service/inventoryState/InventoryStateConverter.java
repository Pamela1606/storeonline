package com.online.store.service.inventoryState;

import com.online.store.models.InventoryState;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryStateConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert InventoryStateDto to InventoryState
     *
     * @param inventoryStateDto a InventoryStateDto
     * @return a InventoryState entity
     */
    public InventoryState toModel(InventoryStateDto inventoryStateDto) {
        return modelMapper.map(inventoryStateDto, InventoryState.class);
    }

    /**
     * Convert InventoryState to InventoryStateDto
     *
     * @param inventoryState a InventoryState
     * @return a InventoryStateDto entity
     */
    public InventoryStateDto toDto(InventoryState inventoryState) {
        return modelMapper.map(inventoryState, InventoryStateDto.class);
    }
}
