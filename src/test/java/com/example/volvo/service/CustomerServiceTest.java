package com.example.volvo.service;


import com.example.volvo.dto.AddressDto;
import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Address;
import com.example.volvo.entity.Customer;
import com.example.volvo.repository.AddressRepository;
import com.example.volvo.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServiceTest {

    @MockBean
    CustomerRepository repository;

    @MockBean
    AddressRepository addressRepository;

    @Autowired
    CustomerService service;

    @Test
    void assertThatCalledToSaveACustomer() {
        CustomerDto mockCustomer = buildCustomerDtoWithAddressesDto();
        service.save(mockCustomer);
        Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any());
    }

    @Test
    void assertThatCalledToDeleteACustomer() {
        service.delete("any-id");
        Mockito.verify(repository, Mockito.times(1)).deleteById(ArgumentMatchers.any(String.class));
    }

    @Test
    void assertThatReturnCustomers() {
        Mockito.when(repository.findAll()).thenReturn(buildTwoCustomersEntity());
        Assertions.assertThat(service.getAll()).hasSize(2);
    }

    @Test
    void assertThatGetByIdDidntReturnCustomer() {
        Mockito.when(repository.findById(ArgumentMatchers.any(String.class))).thenReturn(Optional.empty());
        Assertions.assertThat(service.getById("any-id")).isNull();
    }

    @Test
    void assertThatFoundCustomersByZipCode() {
        List<Address> list = new ArrayList<>();
        Address address = new Address();
        Customer customer = new Customer();

        customer.setName("any-customer");
        address.setCustomers(Set.of(customer));
        list.add(address);

        Mockito.when(addressRepository.findByIdZipCode(ArgumentMatchers.any(String.class))).thenReturn(list);
        Assertions.assertThat(service.getCustomersByZipCode("any-zipcode")).hasAtLeastOneElementOfType(CustomerDto.class);
    }

    private List<Customer> buildTwoCustomersEntity() {
        List<Customer> list = new ArrayList<>();
        list.add(buildCustomerDtoWithSpecificDocumentId("doc-1"));
        list.add(buildCustomerDtoWithSpecificDocumentId("doc-2"));
        return list;
    }


    private CustomerDto buildCustomerDtoWithAddressesDto() {
        CustomerDto customer = new CustomerDto();
        customer.setDocumentId("any-document");
        customer.setName("mock-name");
        customer.setAddresses(buildAddressSet());
        return customer;
    }

    private Customer buildCustomerDtoWithSpecificDocumentId(String documentId) {
        Customer customer = new Customer();
        customer.setDocumentId(documentId);
        customer.setName("mock-name");
        return customer;
    }

    private Set<AddressDto> buildAddressSet() {
        Set<AddressDto> addresses = new HashSet<>();
        addresses.add(buildSingleAddressWithoutCustomers());
        return addresses;
    }

    private AddressDto buildSingleAddressWithoutCustomers() {
        AddressDto dto = new AddressDto();
        dto.setNumber(123L);
        dto.setZipCode("99999-999");
        return dto;
    }


}
