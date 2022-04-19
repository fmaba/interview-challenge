package com.example.volvo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class AddressPrimaryKey implements Serializable {

    @Pattern(regexp = "[0-9]{5}-[0-9]{3}")
    private String zipCode;

    private long number;
}

