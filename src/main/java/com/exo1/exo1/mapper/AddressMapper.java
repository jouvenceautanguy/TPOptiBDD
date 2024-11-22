package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.AddressDto;
import com.exo1.exo1.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AddressMapper {
    AddressDto toDto(Address address);
    Address toEntity(AddressDto addressDto);
    List<AddressDto> toDtos(List<Address> addresses);
    List<Address> toEntities(List<AddressDto> addressDtos);
}
