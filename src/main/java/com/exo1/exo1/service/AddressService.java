package com.exo1.exo1.service;

import com.exo1.exo1.dto.AddressDto;
import com.exo1.exo1.entity.Address;
import com.exo1.exo1.mapper.AddressMapper;
import com.exo1.exo1.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public List<AddressDto> findAll() {
        return addressMapper.toDtos(addressRepository.findAll());
    }

    public AddressDto findById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address not found with id " + id));
        return addressMapper.toDto(address);
    }
    @Transactional
    public AddressDto save(AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);
        return addressMapper.toDto(addressRepository.save(address));
    }

    public AddressDto update(Long id, AddressDto addressDto) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address not found with id " + id));
        addressDto.setId(existingAddress.getId());
        Address addressUpdated = addressMapper.toEntity(addressDto);
        return addressMapper.toDto(addressRepository.save(addressUpdated));
    }
    @Transactional
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
