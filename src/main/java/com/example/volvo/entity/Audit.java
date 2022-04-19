package com.example.volvo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class Audit {

    @CreatedDate
    protected Date createdAt;

    @LastModifiedDate
    protected Date lastUpdatedAt;

}
