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
@RequestMapping("/")
public class CustomerController implements CRUDController<ResponseEntity<Customer>, CustomerDto> {

    @Autowired
    CustomerService service;

    @GetMapping
    public ResponseEntity health() {
        return ResponseEntity.ok("up!");
    }

    @GetMapping("byZipCode")
    public ResponseEntity<List<CustomerDto>> getCustomersByZipCode(@RequestParam String zipCode) {
        return ResponseEntity.ok(service.getCustomersByZipCode(zipCode));
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody CustomerDto customerDto) {
        Optional<Customer> customerOptional = service.insert(customerDto);
        if (customerOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(customerOptional.get());
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody CustomerDto customerDto) {
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Customer> delete(@RequestBody CustomerDto customerDto) {
        return null;
    }
}
