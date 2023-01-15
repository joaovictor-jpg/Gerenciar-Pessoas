package com.github.joaovictorjpg.menage_person.repository;

import com.github.joaovictorjpg.menage_person.entity.AddressStatus;
import com.github.joaovictorjpg.menage_person.entity.pk.AddressPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressStatusRepository extends JpaRepository<AddressStatus, AddressPK> {
}
