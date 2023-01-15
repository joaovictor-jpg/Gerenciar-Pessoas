package com.github.joaovictorjpg.menage_person.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_Address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Street Field Requered")
    private String street;
    @NotNull(message = "Postal Code Field Requered")
    private Integer postalCode;
    @NotNull(message = "Number Field Requered")
    private Integer number;
    @NotEmpty(message = "City Field Requered")
    private String city;
}
