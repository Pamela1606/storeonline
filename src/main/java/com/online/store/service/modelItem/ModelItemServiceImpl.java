package com.online.store.service.modelItem;

import com.online.store.models.ModelItem;
import com.online.store.reporsitory.ModelItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class ModelItemServiceImpl implements ModelItemService {

    @Autowired
    private ModelItemRepository modelItemRepository;

    @Autowired
    private ModelItemConverter modelItemConverter;

    @Override
    public Page<ModelItemDto> findAll(Pageable pageable) {
        return modelItemRepository.findAll(pageable).map(modelItemConverter::toDto);
    }

    @Override
    public ModelItemDto createEntity(ModelItemDto modelItemDto) {
        ModelItem modelItem = modelItemRepository.save(modelItemConverter.toModel(modelItemDto));
        return modelItemConverter.toDto(modelItem);
    }

    @Override
    public ModelItemDto updateEntity(ModelItemDto modelItemDto) {
        Optional<ModelItem> modelItemOptional = modelItemRepository.findById(modelItemDto.getId());
        if (!modelItemOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The ModelItem with %d not exist.", modelItemDto.getId()));
        }
        modelItemRepository.save(modelItemConverter.toModel(modelItemDto));
        return modelItemDto;
    }

    @Override
    public ModelItemDto deleteEntity(Long id) {
        Optional<ModelItem> modelItemOptional = modelItemRepository.findById(id);
        if (!modelItemOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The ModelItem with %d not exist.", id));
        }
        modelItemRepository.delete(modelItemOptional.get());
        return modelItemConverter.toDto(modelItemOptional.get());
    }
}
