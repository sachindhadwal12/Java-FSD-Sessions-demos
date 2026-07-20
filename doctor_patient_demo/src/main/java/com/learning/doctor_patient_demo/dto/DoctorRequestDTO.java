package com.learning.doctor_patient_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorRequestDTO {

    private String name;
    private String Specialization;
    private String email;

    private String phoneNumber;
    private String licenseNumber;
}
