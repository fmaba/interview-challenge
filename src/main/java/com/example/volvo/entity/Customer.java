package com.example.volvo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Customer extends Audit {

    @Id
    @Column(name = "document_id")
    private String documentId;

    private String name;
    private int age;

    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.MERGE})
    @JoinTable(name = "customers_addresses", joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = {@JoinColumn(name = "zipCode"), @JoinColumn(name = "number")})
    private Set<Address> addresses = new HashSet<>();

}
