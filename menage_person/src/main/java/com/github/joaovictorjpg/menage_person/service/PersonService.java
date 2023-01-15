package com.github.joaovictorjpg.menage_person.service;

import com.github.joaovictorjpg.menage_person.controllers.dto.PersonDTO;
import com.github.joaovictorjpg.menage_person.controllers.dto.PersonResponse;
import com.github.joaovictorjpg.menage_person.entity.Person;
import com.github.joaovictorjpg.menage_person.entity.exceptions.ResourceNotFoundException;
import com.github.joaovictorjpg.menage_person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonResponse save(Person person) {
        PersonResponse response = formatefromPersontoPesronResponse(personRepository.save(person));
        return response;
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person update(Long id, PersonDTO personDTO) {

        String name = personDTO.getName().trim();

        return personRepository.findById(id).map(
                person -> {
                    person.setId(id);
                    if(name.isEmpty()){
                        person.setName(person.getName());
                    }else {
                        person.setName(name);
                    }
                    if(personDTO.getBirthDate() == null) {
                        person.setBirthDate(person.getBirthDate());
                    } else {
                        person.setBirthDate(personDTO.getBirthDate());
                    }
                    return personRepository.save(person);
                }).orElseThrow( () -> new ResourceNotFoundException(id));

    }


    private PersonResponse formatefromPersontoPesronResponse(Person obj) {
        return PersonResponse
                .builder()
                .name(obj.getName())
                .birthDate(obj.getBirthDate())
                .build();
    }
}
