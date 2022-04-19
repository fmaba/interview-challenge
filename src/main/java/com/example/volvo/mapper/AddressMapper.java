package com.example.volvo.mapper;

import com.example.volvo.dto.AddressDto;
import com.example.volvo.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "customers", ignore = true)
    @Mapping(target = "id.zipCode", source = "zipCode")
    @Mapping(target = "id.number", source = "number")
    Address fromDto(AddressDto dto);
}
