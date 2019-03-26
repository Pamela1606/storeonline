package com.online.store.service.inventory;

import com.online.store.models.Inventory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert InventoryDto to Inventory
     *
     * @param inventoryDto a InventoryDto
     * @return a Inventory entity
     */
    public Inventory toModel(InventoryDto inventoryDto) {
        return modelMapper.map(inventoryDto, Inventory.class);
    }

    /**
     * Convert Inventory to InventoryDto
     *
     * @param inventory a Inventory
     * @return a InventoryDto entity
     */
    public InventoryDto toDto(Inventory inventory) {
        return modelMapper.map(inventory, InventoryDto.class);
    }
}
