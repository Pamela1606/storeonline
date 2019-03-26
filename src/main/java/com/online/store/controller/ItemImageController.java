package com.online.store.controller;

import com.online.store.models.ItemImage;
import com.online.store.service.itemImage.ItemImageDto;
import com.online.store.service.itemImage.ItemImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/itemImages")
public class ItemImageController {

    @Autowired
    private ItemImageService itemImageService;

    @GetMapping
    public ResponseEntity<Object> getItemImages(Pageable pageable) {
        return new ResponseEntity<>(itemImageService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createItemImage(@RequestBody ItemImageDto itemImageDto) {
        return ResponseEntity.ok(itemImageService.createEntity(itemImageDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItemImage(@PathVariable(value = "id") Long id, @RequestBody ItemImageDto itemImageDto) {
        return ResponseEntity.ok(itemImageService.updateEntity(itemImageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItemImage(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(itemImageService.deleteEntity(id));
    }
}
