package com.online.store.service.capacity;

import com.online.store.models.Capacity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CapacityConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert CapacityDto to Capacity
     *
     * @param capacityDto a CapacityDto
     * @return a Capacity entity
     */
    public Capacity toModel(CapacityDto capacityDto) {
        return modelMapper.map(capacityDto, Capacity.class);
    }

    /**
     * Convert Capacity to CapacityDto
     *
     * @param capacity a Capacity
     * @return a CapacityBrandDto entity
     */
    public CapacityDto toDto(Capacity capacity) {
        return modelMapper.map(capacity, CapacityDto.class);
    }
}
