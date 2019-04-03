package com.online.store.service.item;

import com.online.store.models.*;
import com.online.store.reporsitory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelItemRepository modelItemRepository;

    @Autowired
    private CapacityRepository capacityRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ItemConverter itemConverter;

    @Override
    public Page<ItemDto> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable).map(itemConverter::toDto);
    }

    @Override
    public ItemDto createEntity(ItemDto itemDto) {
        System.out.println(" dto " + itemDto);
        Optional<ModelItem> modelItemOptional = modelItemRepository.findById(itemDto.getModelItemId());
        if (!modelItemOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The ModelItem with %d not exist.", itemDto.getModelItemId()));
        }
        Optional<Category> categoryOptional = categoryRepository.findById(itemDto.getCategoryId());
        if (!categoryOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Category with %d not exist.", itemDto.getCategoryId()));
        }
        Optional<Brand> brandOptional = brandRepository.findById(itemDto.getBrandId());
        if (!brandOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Brand with %d not exist.", itemDto.getBrandId()));
        }
        Item item = itemConverter.toModel(itemDto);
        item.setModelItem(modelItemOptional.get());
        item.setCapacity(itemDto.getCapacity());
        item.setCategory(categoryOptional.get());
        item.setBrand(brandOptional.get());
        itemRepository.save(item);
        return itemConverter.toDto(item);
    }

    @Override
    public ItemDto updateEntity(ItemDto itemDto) {
        Optional<Item> itemOptional = itemRepository.findById(itemDto.getId());
        if (!itemOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Item with %d not exist.", itemDto.getId()));
        }
        itemRepository.save(itemConverter.toModel(itemDto));
        return itemDto;
    }

    @Override
    public ItemDto deleteEntity(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (!itemOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Item with %d not exist.", id));
        }
        itemRepository.delete(itemOptional.get());
        return itemConverter.toDto(itemOptional.get());
    }
}
