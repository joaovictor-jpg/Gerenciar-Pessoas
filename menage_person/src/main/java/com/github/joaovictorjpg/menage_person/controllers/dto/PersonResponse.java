package com.github.joaovictorjpg.menage_person.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {

    private String name;
    private LocalDate birthDate;
}
