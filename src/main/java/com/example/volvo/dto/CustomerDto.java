package com.example.volvo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {
    private String documentId;
    private String name;
    private int age;

    private Set<AddressDto> addresses;
}
