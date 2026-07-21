package com.learning.doctor_patient_demo.service;


import com.learning.doctor_patient_demo.dto.PatientRequestDTO;
import com.learning.doctor_patient_demo.dto.PatientResponseDTO;
import com.learning.doctor_patient_demo.entity.Doctor;
import com.learning.doctor_patient_demo.entity.Patient;
import com.learning.doctor_patient_demo.exception.DoctorNotFoundException;
import com.learning.doctor_patient_demo.repository.DoctorRepository;
import com.learning.doctor_patient_demo.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    // --- Create --------------------------------------------------

    public PatientResponseDTO createPatient(PatientRequestDTO dto){
       Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()-> new DoctorNotFoundException("DOctoe Not found "+ dto.getDoctorId()));

        Patient patient = Patient.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .DOB(dto.getDateOfBirth())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .diagnosis(dto.getDiagnosis())
                .admissionDate(dto.getAdmissionDate())
                .gender(dto.getGender())
                .doctor(doctor)  //<-- set the FK relationship
                .build();
        Patient saved = patientRepository.save(patient);
        return toResponseDTO(saved);


    }



    public List<PatientResponseDTO> getAllPatients(){

        return patientRepository.findAll()
                .stream()
                .map(this::toResponseDTO).collect(Collectors.toList());
    }

    // GET By ID

 public PatientResponseDTO getPatientById(Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Patient Not Found with ID "+ id));
        return toResponseDTO(patient);
 }



 //GET ALL Patients for a Specific Doctor
    public List<PatientResponseDTO> getPatientsByDoctorId(Long doctorId){
        if(!doctorRepository.existsById(doctorId)){
            throw new DoctorNotFoundException("Doctor not found with id"+ doctorId);
        }
        return patientRepository.findByDoctorId(doctorId)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private PatientResponseDTO toResponseDTO(Patient patient){
        return PatientResponseDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .age(patient.getAge())
                .dateOfBirth(patient.getDOB())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .diagnosis(patient.getDiagnosis())
                .admissionDate(patient.getAdmissionDate())
                .gender(patient.getGender())
                .doctorId(patient.getDoctor().getId())
                .doctorName(patient.getDoctor().getName())
                .doctorSpecialization(patient.getDoctor().getSpecialization())
                .build();


    }
}
