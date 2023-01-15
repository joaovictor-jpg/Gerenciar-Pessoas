package com.github.joaovictorjpg.menage_person.service;

import com.github.joaovictorjpg.menage_person.controllers.dto.PersonDTO;
import com.github.joaovictorjpg.menage_person.entity.Address;
import com.github.joaovictorjpg.menage_person.entity.exceptions.ResourceNotFoundException;
import com.github.joaovictorjpg.menage_person.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAll(Address filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);
        return addressRepository.findAll(example);
    }

    public Address findById(Long id) {
        Optional<Address> obj = addressRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Address personDTO_address(Address address, PersonDTO obj) {

        if(obj.getStreet() == null || obj.getStreet().trim().isEmpty()) {
            address.setStreet(address.getStreet());
        } else {
            address.setStreet(obj.getStreet().trim());
        }

        if(obj.getPostalCode() != null) {
            address.setPostalCode(obj.getPostalCode());
        } else {
            address.setPostalCode(address.getPostalCode());
        }

        if(obj.getNumber() != null) {
            address.setNumber(obj.getNumber());
        } else {
            address.setNumber(address.getNumber());
        }

        if(obj.getCity() == null || obj.getStreet().trim().isEmpty()) {
            address.setCity(address.getCity());
        } else {
            address.setCity(obj.getCity());
        }

        return addressRepository.save(address);

    }
}
