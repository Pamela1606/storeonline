package com.online.store.controller;

import com.online.store.service.item.ItemDto;
import com.online.store.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<Object> getItems(Pageable pageable) {
        return new ResponseEntity<>(itemService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createItem(@RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.createEntity(itemDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable(value = "id") Long id, @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.updateEntity(itemDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(itemService.deleteEntity(id));
    }
}
