package com.learning.doctor_patient_demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is Mandatory")
    private String name;
    @NotBlank(message = "Specialization is Mandatory")
    private String specialization;
    @Email(message = "INvalid mail format")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @NotBlank(message = "License number is mandatory")
    private String licenseNumber;

    //mapped by - doctor --> refers to the doctor field in the patient class

// if doctor is deleted , all their patient will also be deleted
    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonBackReference
    @Builder.Default
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient){
        patients.add(patient);
        patient.setDoctor(this);
    }
    public void removePatient(Patient patient){
        patients.remove(patient);
        patient.setDoctor(null);
    }

}
