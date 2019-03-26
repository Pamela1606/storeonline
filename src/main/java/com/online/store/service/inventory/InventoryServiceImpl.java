package com.online.store.service.inventory;

import com.online.store.models.Inventory;
import com.online.store.models.InventoryState;
import com.online.store.models.Item;
import com.online.store.reporsitory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private InventoryStateRepository inventoryStateRepository;

    @Autowired
    private InventoryConverter inventoryConverter;

    @Override
    public Page<InventoryDto> findAll(Pageable pageable) {
        return inventoryRepository.findAll(pageable).map(inventoryConverter::toDto);
    }

    @Override
    public InventoryDto createEntity(InventoryDto inventoryDto) {
        Optional<Item> itemOptional = itemRepository.findById(inventoryDto.getItemId());
        if (!itemOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Item with %d not exist.", inventoryDto.getItemId()));
        }
        Optional<InventoryState> inventoryStateOptional = inventoryStateRepository.findById(inventoryDto.getInventoryStateId());
        if (!inventoryStateOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The InventoryState with %d not exist.", inventoryDto.getInventoryStateId()));
        }
        Inventory inventory = inventoryConverter.toModel(inventoryDto);
        inventory.setItem(itemOptional.get());
        inventory.setInventoryState(inventoryStateOptional.get());
        inventoryRepository.save(inventory);
        return inventoryConverter.toDto(inventory);
    }

    @Override
    public InventoryDto updateEntity(InventoryDto inventoryDto) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(inventoryDto.getId());
        if (!inventoryOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Inventory with %d not exist.", inventoryDto.getId()));
        }
        inventoryRepository.save(inventoryConverter.toModel(inventoryDto));
        return inventoryDto;
    }

    @Override
    public InventoryDto deleteEntity(Long id) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        if (!inventoryOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Inventory with %d not exist.", id));
        }
        inventoryRepository.delete(inventoryOptional.get());
        return inventoryConverter.toDto(inventoryOptional.get());
    }
}
