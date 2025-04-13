package com.java.planning.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<T> implements IEntity<T> {

    @Column(name = "CREATIONTIME")
    @CreationTimestamp
    public Date creationDate;

    @Column(name = "LASTMODIFYTIME")
    @UpdateTimestamp
    protected Date lastModifyDate;
}
