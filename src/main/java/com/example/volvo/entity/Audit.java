package com.example.volvo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class Audit {

    @Column(updatable = false)
    @CreatedDate
    protected Date createdAt;

    @Column(insertable = false)
    @LastModifiedDate
    protected Date lastUpdatedAt;

}
