package com.example.volvo.controller;

import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Customer;
import com.example.volvo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody CustomerDto customerDto) {
        Customer customer = service.save(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("")
    public ResponseEntity<Customer> update(@RequestBody CustomerDto customerDto) {
        Customer customer = service.save(customerDto);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerDto>> all() {
        List<CustomerDto> customers = service.getAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> byId(@PathVariable String id) {
        CustomerDto customer = service.getById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/byZipCode")
    public ResponseEntity<List<CustomerDto>> getCustomersByZipCode(@RequestParam String value) {
        List<CustomerDto> customersByZipCode = service.getCustomersByZipCode(value);
        return ResponseEntity.ok(customersByZipCode);
    }
}
