package com.online.store.service.capacity;

import com.online.store.models.Capacity;
import com.online.store.reporsitory.CapacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class CapacityServiceImpl implements CapacityService {

    @Autowired
    private CapacityRepository capacityRepository;

    @Autowired
    private CapacityConverter capacityConverter;

    @Override
    public Page<CapacityDto> findAll(Pageable pageable) {
        return capacityRepository.findAll(pageable).map(capacityConverter::toDto);
    }

    @Override
    public CapacityDto createEntity(CapacityDto capacityDto) {
        Capacity capacity = capacityRepository.save(capacityConverter.toModel(capacityDto));
        return capacityConverter.toDto(capacity);
    }

    @Override
    public CapacityDto updateEntity(CapacityDto capacityDto) {
        Optional<Capacity> capacityOptional = capacityRepository.findById(capacityDto.getId());
        if (!capacityOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Capacity with %d not exist.", capacityDto.getId()));
        }
        capacityRepository.save(capacityConverter.toModel(capacityDto));
        return capacityDto;
    }

    @Override
    public CapacityDto deleteEntity(Long id) {
        Optional<Capacity> capacityOptional = capacityRepository.findById(id);
        if (!capacityOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Capacity with %d not exist.", id));
        }
        capacityRepository.delete(capacityOptional.get());
        return capacityConverter.toDto(capacityOptional.get());
    }
}
