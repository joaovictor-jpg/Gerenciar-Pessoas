package com.github.joaovictorjpg.menage_person.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.joaovictorjpg.menage_person.entity.pk.AddressPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_Address_Status")
public class AddressStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AddressPK id = new AddressPK();
    @NotNull(message = "Status Field Requered")
    private Boolean status;

    public AddressStatus() {
    }

    public AddressStatus(Address address, Person person, Boolean status) {
        id.setAddress(address);
        id.setPerson(person);
        this.status = status;
    }

    public Address getAddress() {
        return id.getAddress();
    }

    public void setAddress(Address address) {
        id.setAddress(address);
    }

    @JsonIgnore
    public Person getPerson() {
        return id.getPerson();
    }

    public void setPerson(Person person) {
        id.setPerson(person);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressStatus that = (AddressStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
