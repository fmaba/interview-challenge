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
public class CustomerController implements CRUDController<ResponseEntity<Customer>, CustomerDto> {

    @Autowired
    CustomerService service;

    @GetMapping("/byZipCode")
    public ResponseEntity<List<CustomerDto>> getCustomersByZipCode(@RequestParam String value) {
        List<CustomerDto> customersByZipCode = service.getCustomersByZipCode(value);
        return ResponseEntity.ok(customersByZipCode);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody CustomerDto customerDto) {
        Customer customer = service.insert(customerDto);
        return ResponseEntity.ok(customer);
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
