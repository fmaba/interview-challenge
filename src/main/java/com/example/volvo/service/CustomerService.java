package com.example.volvo.service;

import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Customer;
import com.example.volvo.mapper.CustomerMapper;
import com.example.volvo.repository.AddressRepository;
import com.example.volvo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerMapper mapper;

    public Optional<Customer> insert(CustomerDto dto) {
        Customer customer = mapper.fromDto(dto);
        return Optional.of(repository.save(customer));
    }

    public List<CustomerDto> getCustomersByZipCode(String zipCode) {
        List<Customer> customers = addressRepository.findCustomersByZipCode(zipCode);
        return mapper.toListDto(customers);
    }

}
