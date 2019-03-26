package com.online.store.service.inventoryState;

import com.online.store.models.InventoryState;
import com.online.store.reporsitory.InventoryStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class InventoryStateServiceImpl implements InventoryStateService {

    @Autowired
    private InventoryStateRepository inventoryStateRepository;

    @Autowired
    private InventoryStateConverter inventoryStateConverter;

    @Override
    public Page<InventoryStateDto> findAll(Pageable pageable) {
        return inventoryStateRepository.findAll(pageable).map(inventoryStateConverter::toDto);
    }

    @Override
    public InventoryStateDto createEntity(InventoryStateDto inventoryStateDto) {
        InventoryState inventoryState = inventoryStateRepository.save(inventoryStateConverter.toModel(inventoryStateDto));
        return inventoryStateConverter.toDto(inventoryState);
    }

    @Override
    public InventoryStateDto updateEntity(InventoryStateDto inventoryStateDto) {
        Optional<InventoryState> inventoryStateOptional = inventoryStateRepository.findById(inventoryStateDto.getId());
        if (!inventoryStateOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The InventoryState with %d not exist.", inventoryStateDto.getId()));
        }
        inventoryStateRepository.save(inventoryStateConverter.toModel(inventoryStateDto));
        return inventoryStateDto;
    }

    @Override
    public InventoryStateDto deleteEntity(Long id) {
        Optional<InventoryState> inventoryStateOptional = inventoryStateRepository.findById(id);
        if (!inventoryStateOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The InventoryState with %d not exist.", id));
        }
        inventoryStateRepository.delete(inventoryStateOptional.get());
        return inventoryStateConverter.toDto(inventoryStateOptional.get());
    }
}
