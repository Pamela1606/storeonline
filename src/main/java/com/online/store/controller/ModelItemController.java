package com.online.store.controller;

import com.online.store.models.ModelItem;
import com.online.store.service.modelItem.ModelItemDto;
import com.online.store.service.modelItem.ModelItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/modelItems")
public class ModelItemController {

    @Autowired
    private ModelItemService modelItemService;

    @GetMapping
    public ResponseEntity<Object> getModelItems(Pageable pageable) {
        return new ResponseEntity<>(modelItemService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createModelItem(@RequestBody ModelItemDto modelItemDto) {
        return ResponseEntity.ok(modelItemService.createEntity(modelItemDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateModelItem(@PathVariable(value = "id") Long id, @RequestBody ModelItemDto modelItemDto) {
        return ResponseEntity.ok(modelItemService.updateEntity(modelItemDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteModelItem(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(modelItemService.deleteEntity(id));
    }
}
