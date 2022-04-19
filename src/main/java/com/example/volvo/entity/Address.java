package com.example.volvo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Address {

    @EmbeddedId
    private AddressPrimaryKey id;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
    private List<Customer> customers;
}
