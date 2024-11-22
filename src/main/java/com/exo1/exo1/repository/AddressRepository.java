package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
