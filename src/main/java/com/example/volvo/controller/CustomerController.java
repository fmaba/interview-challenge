package com.example.volvo.controller;

import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Customer;
import com.example.volvo.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("")
    @Operation(summary = "Send new customer.")
    public ResponseEntity<Customer> create(@RequestBody CustomerDto customerDto) {
        Customer customer = service.save(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("")
    @Operation(summary = "Update existing customer.")
    public ResponseEntity<Customer> update(@RequestBody CustomerDto customerDto) {
        Customer customer = service.save(customerDto);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete specified customer by id.")
    public ResponseEntity<Customer> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    @Operation(summary = "Get all customers.")
    public ResponseEntity<List<CustomerDto>> all() {
        List<CustomerDto> customers = service.getAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specific customer by it's id.")
    public ResponseEntity<CustomerDto> byId(@PathVariable String id) {
        CustomerDto customer = service.getById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/byZipCode")
    @Operation(summary = "Get all customers from a specific Zipcode.")
    public ResponseEntity<List<CustomerDto>> getCustomersByZipCode(@RequestParam String value) {
        List<CustomerDto> customersByZipCode = service.getCustomersByZipCode(value);
        return ResponseEntity.ok(customersByZipCode);
    }
}
