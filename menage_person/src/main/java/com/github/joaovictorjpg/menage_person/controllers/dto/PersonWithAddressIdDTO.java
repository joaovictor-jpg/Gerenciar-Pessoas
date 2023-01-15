package com.github.joaovictorjpg.menage_person.controllers.dto;

import jakarta.validation.constraints.NotNull;

public class PersonWithAddressIdDTO {

    private Long person_id;
    private Long addresss_id;
    @NotNull(message = "Status Field NotNull")
    private Boolean status;

    public PersonWithAddressIdDTO() {
    }

    public PersonWithAddressIdDTO(Long person_id, Long addresss_id, Boolean status) {
        this.person_id = person_id;
        this.addresss_id = addresss_id;
        this.status = status;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public Long getAddresss_id() {
        return addresss_id;
    }

    public void setAddresss_id(Long addresss_id) {
        this.addresss_id = addresss_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
