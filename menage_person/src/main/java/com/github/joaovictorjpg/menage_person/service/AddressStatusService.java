package com.github.joaovictorjpg.menage_person.service;

import com.github.joaovictorjpg.menage_person.entity.AddressStatus;
import com.github.joaovictorjpg.menage_person.repository.AddressStatusRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressStatusService {

    @Autowired
    private AddressStatusRepository addressStatusRepository;

    public void save(@Valid AddressStatus status) {
        addressStatusRepository.save(status);
    }
}
