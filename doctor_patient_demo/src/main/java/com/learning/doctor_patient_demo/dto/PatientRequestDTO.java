package com.learning.doctor_patient_demo.dto;

import com.learning.doctor_patient_demo.entity.Patient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequestDTO {

    @NotBlank(message = "Patient Name is required")
    private String name;
    @Min(value = 1,message = "Age must be positive")
    @Max(value = 100 )
    private int age;

    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String diagnosis;
    private LocalDate admissionDate;
    private Patient.Gender gender;

    private Long doctorId;

}
