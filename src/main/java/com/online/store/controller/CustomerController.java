package com.online.store.controller;

import com.online.store.service.customer.CustomerDto;
import com.online.store.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> getCustomers(Pageable pageable) {
        return new ResponseEntity<>(customerService.findAll(pageable).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.createEntity(customerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.updateEntity(customerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(customerService.deleteEntity(id));
    }
}
