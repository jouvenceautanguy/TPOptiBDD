package com.exo1.exo1.service;

import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.Address;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.mapper.UserMapper;
import com.exo1.exo1.repository.AddressRepository;
import com.exo1.exo1.repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressRepository addressRepository;

    @Cacheable("users")
    public Page<UserDto> findAll(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest).map(userMapper::toDto);
    }
    @Cacheable("users")
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id " + id));
        return userMapper.toDto(user);
    }
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        if (user.getAddress() != null && user.getAddress().getId() == null) {
            Address address = addressRepository.save(user.getAddress());
            user.setAddress(address);
        }
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto update(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id " + id));
        userDto.setId(existingUser.getId());
        User userUpdated = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(userUpdated));
    }
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void clearCache() {
    }
}
