package com.github.joaovictorjpg.menage_person.entity.pk;

import com.github.joaovictorjpg.menage_person.entity.Address;
import com.github.joaovictorjpg.menage_person.entity.Person;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AddressPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressPK addressPK = (AddressPK) o;
        return address.equals(addressPK.address) && person.equals(addressPK.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, person);
    }
}
