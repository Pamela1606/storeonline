package com.online.store.controller;

import com.online.store.service.sale.SaleDto;
import com.online.store.service.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Object> getSales(Pageable pageable) {
        return new ResponseEntity<>(saleService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createSale(@RequestBody SaleDto saleDto) {
        return ResponseEntity.ok(saleService.createEntity(saleDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSale(@PathVariable(value = "id") Long id, @RequestBody SaleDto saleDto) {
        return ResponseEntity.ok(saleService.updateEntity(saleDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSale(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(saleService.deleteEntity(id));
    }
}
