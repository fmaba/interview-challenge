package com.example.volvo.repository;

import com.example.volvo.entity.Address;
import com.example.volvo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Customer> findCustomersByZipCode(String zipCode);
}