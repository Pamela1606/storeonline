package com.online.store.controller;

import com.online.store.service.capacity.CapacityDto;
import com.online.store.service.capacity.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/capacities")
public class CapacityController {

    @Autowired
    private CapacityService capacityService;

    @GetMapping
    public ResponseEntity<Object> getCapacities(Pageable pageable) {
        return new ResponseEntity<>(capacityService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCapacity(@RequestBody CapacityDto capacityDto) {
        return ResponseEntity.ok(capacityService.createEntity(capacityDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCapacity(@PathVariable(value = "id") Long id, @RequestBody CapacityDto capacityDto) {
        return ResponseEntity.ok(capacityService.updateEntity(capacityDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCapacity(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(capacityService.deleteEntity(id));
    }
}
