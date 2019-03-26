package com.online.store.service.item;

import com.online.store.models.Item;
import com.online.store.reporsitory.ItemRepository;
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
    private ItemConverter itemConverter;

    @Override
    public Page<ItemDto> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable).map(itemConverter::toDto);
    }

    @Override
    public ItemDto createEntity(ItemDto itemDto) {
        Item item = itemRepository.save(itemConverter.toModel(itemDto));
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
