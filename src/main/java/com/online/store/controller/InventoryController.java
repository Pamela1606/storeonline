package com.online.store.controller;

import com.online.store.service.inventory.InventoryDto;
import com.online.store.service.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Object> getInventories(Pageable pageable) {
        return new ResponseEntity<>(inventoryService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createInventory(@RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.createEntity(inventoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInventory(@PathVariable(value = "id") Long id, @RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.updateEntity(inventoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInventory(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(inventoryService.deleteEntity(id));
    }
}
