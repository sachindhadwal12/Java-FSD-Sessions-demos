package com.learning.doctor_patient_demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="Patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is Mandatory")
    private String name;
    @Min(value = 1, message = "Age must be positive number")
    private int age;
    private LocalDate DOB;

    private String email;
    private String phoneNumber;
    private String diagnosis;
    private LocalDate admissionData;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public enum Gender{
        Male,Female,Other
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference
    private Doctor doctor;
}
