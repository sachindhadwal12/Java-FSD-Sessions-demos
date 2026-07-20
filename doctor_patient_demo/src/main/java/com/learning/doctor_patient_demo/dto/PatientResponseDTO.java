package com.learning.doctor_patient_demo.dto;

import com.learning.doctor_patient_demo.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDTO {

    private Long id;
    private String name;
    private  int age;
    private LocalDate dateOfBirth;
    private  String email;
    private String phoneNumber;
    private String diagnosis;
    private String admissionDate;
    private Patient.Gender gender;

    private  Long doctorId;
    private String doctorName;
    private String doctorSpecialization;
}
