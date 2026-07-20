package com.learning.doctor_patient_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponseDTO {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String phoneNumber;
    private String licenseNumber;
    private int totalPatient;
    private List<PatientResponseDTO> patients;
}
