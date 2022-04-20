package com.example.volvo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private long number;
    private Set<CustomerDto> customers;
    private String zipCode;

}
