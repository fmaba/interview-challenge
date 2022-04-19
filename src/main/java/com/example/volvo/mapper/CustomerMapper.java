package com.example.volvo.mapper;

import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer fromDto(CustomerDto customerDto);
    @InheritInverseConfiguration
    CustomerDto toDto(Customer customer);

    List<Customer> fromListDto (List<CustomerDto> list);
    @InheritInverseConfiguration
    List<CustomerDto> toListDto(List<Customer> customer);
}
