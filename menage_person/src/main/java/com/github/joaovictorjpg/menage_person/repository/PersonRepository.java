package com.github.joaovictorjpg.menage_person.repository;

import com.github.joaovictorjpg.menage_person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
