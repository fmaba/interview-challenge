package com.example.volvo.mapper;

import com.example.volvo.dto.AddressDto;
import com.example.volvo.dto.CustomerDto;
import com.example.volvo.entity.Address;
import com.example.volvo.entity.AddressPrimaryKey;
import com.example.volvo.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "addresses", source = "addresses", qualifiedByName = "toAddressListEntity")
    Customer fromDto(CustomerDto customerDto);

    @InheritInverseConfiguration
    @Mapping(target = "addresses", source = "addresses", qualifiedByName = "toDtoAddressList")
    CustomerDto toDto(Customer customer);

    List<Customer> fromListDto(List<CustomerDto> list);

    @InheritInverseConfiguration
    List<CustomerDto> toListDto(List<Customer> customer);

    List<Customer> fromSetToList(Set<Customer> set);

    @Named("toAddressListEntity")
    default Set<Address> toAddressListEntity(Set<AddressDto> list) {
        Set<Address> result = new HashSet<>();
        list.forEach(dto -> {
            Address address = new Address();
            AddressPrimaryKey primaryKey = new AddressPrimaryKey();
            primaryKey.setZipCode(dto.getZipCode());
            primaryKey.setNumber(dto.getNumber());
            address.setId(primaryKey);
            result.add(address);
        });
        return result;
    }

    @Named("toDtoAddressList")
    default Set<AddressDto> toDtoAddressList(Set<Address> list) {
        Set<AddressDto> result = new HashSet<>();
        list.forEach(entity -> {
            AddressDto address = new AddressDto();
            address.setNumber(entity.getId().getNumber());
            address.setZipCode(entity.getId().getZipCode());
            result.add(address);
        });
        return result;
    }
}
