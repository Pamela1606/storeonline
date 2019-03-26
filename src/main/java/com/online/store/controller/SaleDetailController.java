package com.online.store.controller;

import com.online.store.service.saleDetail.SaleDetailDto;
import com.online.store.service.saleDetail.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/saleDetails")
public class SaleDetailController {

    @Autowired
    private SaleDetailService saleDetailService;

    @GetMapping
    public ResponseEntity<Object> getSaleDetails(Pageable pageable) {
        return new ResponseEntity<>(saleDetailService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createSaleDetail(@RequestBody SaleDetailDto saleDetailDto) {
        return ResponseEntity.ok(saleDetailService.createEntity(saleDetailDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSaleDetail(@PathVariable(value = "id") Long id, @RequestBody SaleDetailDto saleDetailDto) {
        return ResponseEntity.ok(saleDetailService.updateEntity(saleDetailDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSaleDetail(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(saleDetailService.deleteEntity(id));
    }
}
