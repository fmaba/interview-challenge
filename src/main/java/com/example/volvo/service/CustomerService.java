package com.example.volvo.service;

import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Address;
import com.example.volvo.entity.AddressPrimaryKey;
import com.example.volvo.entity.Customer;
import com.example.volvo.mapper.CustomerMapper;
import com.example.volvo.repository.AddressRepository;
import com.example.volvo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerMapper mapper;

    public Customer insert(CustomerDto dto) {
        Customer customer = mapper.fromDto(dto);
        return repository.save(customer);
    }

    public List<CustomerDto> getCustomersByZipCode(String zipCode) {
        List<Address> addresses = addressRepository.findByIdZipCode(zipCode);
        Set<Customer> result = convertListToSet(addresses);
        List<Customer> customerList = mapper.fromSetToList(result);
        return mapper.toListDto(customerList);
    }

    private AddressPrimaryKey buildPrimaryKey(String zipCode) {
        AddressPrimaryKey key = new AddressPrimaryKey();
        key.setZipCode(zipCode);
        return key;
    }

    private Set<Customer> convertListToSet(List<Address> addresses) {
        Set<Customer> result = new HashSet<>();
        addresses.stream().map(Address::getCustomers).forEach(result::addAll);
        return result;
    }

}
