package com.example.volvo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Pattern(regexp = "[0-9]{5}-[0-9]{3}")
    private String zipCode;

    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;

    private long number;
}
