package com.example.volvo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Address {

    @EmbeddedId
    @Valid
    private AddressPrimaryKey id;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<>();
}
