package com.online.store.service.modelItem;

import com.online.store.models.ModelItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelItemConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert ModelItemDto to ModelItem
     *
     * @param modelItemDto a ModelItemDto
     * @return a ModelItem entity
     */
    public ModelItem toModel(ModelItemDto modelItemDto) {
        return modelMapper.map(modelItemDto, ModelItem.class);
    }

    /**
     * Convert ModelItem to ModelItemDto
     *
     * @param modelItem a ModelItem
     * @return a ModelItemDto entity
     */
    public ModelItemDto toDto(ModelItem modelItem) {
        return modelMapper.map(modelItem, ModelItemDto.class);
    }
}
