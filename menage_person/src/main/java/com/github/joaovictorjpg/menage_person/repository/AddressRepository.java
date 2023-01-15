package com.github.joaovictorjpg.menage_person.repository;

import com.github.joaovictorjpg.menage_person.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
