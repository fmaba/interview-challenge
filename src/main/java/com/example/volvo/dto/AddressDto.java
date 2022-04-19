package com.example.volvo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private long number;
    private List<CustomerDto> customers;
    private String zipCode;

}
