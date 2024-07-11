package com.springlessons.clinicadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "patient")
public class Patient {
    @Id
    private long id;

    private String email;
}
