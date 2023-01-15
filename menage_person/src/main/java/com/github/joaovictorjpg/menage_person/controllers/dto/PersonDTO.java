package com.github.joaovictorjpg.menage_person.controllers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String name;
    @PastOrPresent(message = "birth Date Field Requered")
    private LocalDate birthDate;
    private Long id_address;
    private String street;
    private Integer postalCode;
    private Integer number;
    private String city;
    private Boolean status;

}
