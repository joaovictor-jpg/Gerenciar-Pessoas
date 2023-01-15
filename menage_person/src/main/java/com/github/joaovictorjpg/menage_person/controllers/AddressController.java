package com.github.joaovictorjpg.menage_person.controllers;

import com.github.joaovictorjpg.menage_person.entity.Address;
import com.github.joaovictorjpg.menage_person.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody @Valid Address address) {
        return ResponseEntity.ok().body(addressService.save(address));
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll(@RequestBody Address filter) {
        return ResponseEntity.ok().body(addressService.findAll(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(addressService.findById(id));
    }

}
