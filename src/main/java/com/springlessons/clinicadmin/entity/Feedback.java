package com.springlessons.clinicadmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
@AllArgsConstructor
@Getter
@Setter
public class Feedback {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime createdAt;

    private boolean activeStatus;


    public Feedback() {

    }
}
