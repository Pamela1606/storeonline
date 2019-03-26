package com.online.store.controller;

import com.online.store.models.InventoryState;
import com.online.store.service.inventoryState.InventoryStateDto;
import com.online.store.service.inventoryState.InventoryStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/inventoryStates")
public class InventoryStateController {

    @Autowired
    private InventoryStateService inventoryStateService;

    @GetMapping
    public ResponseEntity<Object> getInventoryStates(Pageable pageable) {
        return new ResponseEntity<>(inventoryStateService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createInventoryState(@RequestBody InventoryStateDto inventoryStateDto) {
        return ResponseEntity.ok(inventoryStateService.createEntity(inventoryStateDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInventoryState(@PathVariable(value = "id") Long id, @RequestBody InventoryStateDto inventoryStateDto) {
        return ResponseEntity.ok(inventoryStateService.updateEntity(inventoryStateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInventorySate(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(inventoryStateService.deleteEntity(id));
    }
}
