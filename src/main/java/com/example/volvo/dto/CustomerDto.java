package com.example.volvo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {
    private String documentId;
    private String name;
    private int age;

    @Valid
    private List<AddressDto> addresses;
}
