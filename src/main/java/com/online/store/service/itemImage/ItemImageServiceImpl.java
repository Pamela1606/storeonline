package com.online.store.service.itemImage;

import com.online.store.models.Item;
import com.online.store.models.ItemImage;
import com.online.store.reporsitory.ItemImageRepository;
import com.online.store.reporsitory.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class ItemImageServiceImpl implements ItemImageService {

    @Autowired
    private ItemImageRepository itemImageRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemImageConverter itemImageConverter;

    @Override
    public Page<ItemImageDto> findAll(Pageable pageable) {
        return itemImageRepository.findAll(pageable).map(itemImageConverter::toDto);
    }

    @Override
    public ItemImageDto createEntity(ItemImageDto itemImageDto) {
        Optional<Item> itemOptional = itemRepository.findById(itemImageDto.getItemId());
        if (!itemOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Item with %d not exist.", itemImageDto.getItemId()));
        }
        ItemImage itemImage = itemImageConverter.toModel(itemImageDto);
        itemImage.setItem(itemOptional.get());
        itemImageRepository.save(itemImage);
        return itemImageConverter.toDto(itemImage);
    }

    @Override
    public ItemImageDto updateEntity(ItemImageDto itemImageDto) {
        Optional<ItemImage> itemImageOptional = itemImageRepository.findById(itemImageDto.getId());
        if (!itemImageOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The ItemImage with %d not exist.", itemImageDto.getId()));
        }
        itemImageRepository.save(itemImageConverter.toModel(itemImageDto));
        return itemImageDto;
    }

    @Override
    public ItemImageDto deleteEntity(Long id) {
        Optional<ItemImage> itemImageOptional = itemImageRepository.findById(id);
        if (!itemImageOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The ItemImage with %d not exist.", id));
        }
        itemImageRepository.delete(itemImageOptional.get());
        return itemImageConverter.toDto(itemImageOptional.get());
    }
}
