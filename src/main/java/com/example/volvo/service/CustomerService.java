package com.example.volvo.service;

import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Address;
import com.example.volvo.entity.Customer;
import com.example.volvo.mapper.CustomerMapper;
import com.example.volvo.repository.AddressRepository;
import com.example.volvo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerMapper mapper;

    public Customer save(CustomerDto dto) {
        Customer customer = mapper.fromDto(dto);
        return repository.save(customer);
    }

    public void delete(String documentId) {
        repository.deleteById(documentId);
    }

    public List<CustomerDto> getCustomersByZipCode(String zipCode) {
        List<Address> addresses = addressRepository.findByIdZipCode(zipCode);
        Set<Customer> result = convertListToSet(addresses);
        List<Customer> customerList = mapper.fromSetToList(result);
        return mapper.toListDto(customerList);
    }

    private Set<Customer> convertListToSet(List<Address> addresses) {
        Set<Customer> result = new HashSet<>();
        addresses.stream().map(Address::getCustomers).forEach(result::addAll);
        return result;
    }

    public List<CustomerDto> getAll() {
        return mapper.toListDto(repository.findAll());
    }

    public CustomerDto getById(String id) {
        Optional<Customer> customer = repository.findById(id);
        return customer.map(value -> mapper.toDto(value)).orElse(null);
    }
}
