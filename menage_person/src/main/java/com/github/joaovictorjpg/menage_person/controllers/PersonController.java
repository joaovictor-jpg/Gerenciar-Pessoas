package com.github.joaovictorjpg.menage_person.controllers;

import com.github.joaovictorjpg.menage_person.controllers.dto.PersonDTO;
import com.github.joaovictorjpg.menage_person.controllers.dto.PersonResponse;
import com.github.joaovictorjpg.menage_person.controllers.dto.PersonWithAddressIdDTO;
import com.github.joaovictorjpg.menage_person.entity.Address;
import com.github.joaovictorjpg.menage_person.entity.AddressStatus;
import com.github.joaovictorjpg.menage_person.entity.Person;
import com.github.joaovictorjpg.menage_person.service.AddressService;
import com.github.joaovictorjpg.menage_person.service.AddressStatusService;
import com.github.joaovictorjpg.menage_person.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressStatusService addressStatusService;

    @PostMapping
    public ResponseEntity<PersonResponse> save(@RequestBody @Valid Person person) {
        return ResponseEntity.ok().body(personService.save(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> people = personService.findAll();
        return ResponseEntity.ok().body(people);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) {

        Person person = personService.update(id, personDTO);

        if(!personDTO.getId_address().equals(null) || personDTO.equals(0)) {

            Address address = addressService.findById(personDTO.getId_address());

            address = addressService.personDTO_address(address, personDTO);

            if(personDTO.getStatus() != null) {
                addressStatusService.save(new AddressStatus(address, person, personDTO.getStatus()));
            }
        }

        return ResponseEntity.ok().body(person);
    }

    @PostMapping()
    @RequestMapping("/addAddress")
    public ResponseEntity<Person> addAddress(@RequestBody @Valid PersonWithAddressIdDTO personWithAddressIdDTO) {
        Person person = personService.findById(personWithAddressIdDTO.getPerson_id());
        Address address = addressService.findById(personWithAddressIdDTO.getAddresss_id());
        addressStatusService.save(new AddressStatus(address, person, personWithAddressIdDTO.getStatus()));
        return ResponseEntity.ok().body(person);
    }

}
