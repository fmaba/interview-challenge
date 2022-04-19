package com.example.volvo.mapper;

import com.example.volvo.dto.AddressDto;
import com.example.volvo.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {


    Address fromDto(AddressDto dto);
}
