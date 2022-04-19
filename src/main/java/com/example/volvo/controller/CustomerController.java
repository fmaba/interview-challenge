package com.example.volvo.controller;

import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Customer;
import com.example.volvo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController implements CRUDController<ResponseEntity<Customer>, CustomerDto> {

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

    @DeleteMapping("")
    public ResponseEntity<Customer> delete(@RequestBody CustomerDto customerDto) {
        service.delete(customerDto.getDocumentId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byZipCode")
    public ResponseEntity<List<CustomerDto>> getCustomersByZipCode(@RequestParam String value) {
        List<CustomerDto> customersByZipCode = service.getCustomersByZipCode(value);
        return ResponseEntity.ok(customersByZipCode);
    }
}
