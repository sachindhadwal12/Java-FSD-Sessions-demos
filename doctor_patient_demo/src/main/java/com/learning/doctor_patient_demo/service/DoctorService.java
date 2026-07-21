package com.learning.doctor_patient_demo.service;

import com.learning.doctor_patient_demo.dto.DoctorRequestDTO;
import com.learning.doctor_patient_demo.dto.DoctorResponseDTO;
import com.learning.doctor_patient_demo.dto.PatientResponseDTO;
import com.learning.doctor_patient_demo.entity.Doctor;
import com.learning.doctor_patient_demo.exception.DoctorNotFoundException;
import com.learning.doctor_patient_demo.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DoctorService {


    private final DoctorRepository doctorRepository;


    // create

    public DoctorResponseDTO createDoctor(DoctorRequestDTO dto){
        if (doctorRepository.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Doctor With Email" + dto.getEmail() + "already Exists");
        }
        Doctor doctor = Doctor.builder()
                .name(dto.getName())
                .specialization(dto.getSpecialization())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .licenseNumber(dto.getLicenseNumber())
                .build();
        Doctor savedDoctor = doctorRepository.save(doctor);
        return toResponseDTO(savedDoctor,false);
    }

    public List<DoctorResponseDTO> getAllDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(doctor -> toResponseDTO(doctor,false))
                .collect(Collectors.toList());
    }

    public DoctorResponseDTO getDoctorById(Long Id){
        Doctor doctor = doctorRepository.findByIdWithPatients(Id)
                .orElseThrow(()-> new DoctorNotFoundException("Doctor Not found with id "+ Id));
        return toResponseDTO(doctor,true);
    }

    public List<DoctorResponseDTO> getDoctorsBySpecialization(String specialization){
        List<Doctor> doctors = doctorRepository.findBySpecialization(specialization);
        return doctors.stream()
                .map(doctor -> toResponseDTO(doctor,false)
                ).collect(Collectors.toList());
    }

    public void deleteDoctor(Long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new DoctorNotFoundException("Doctor Not found with id "+ id));
doctorRepository.delete(doctor);
    }






    private DoctorResponseDTO toResponseDTO(Doctor doctor, boolean includePatients){
        DoctorResponseDTO dto = DoctorResponseDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .specialization(doctor.getSpecialization())
                .email(doctor.getEmail())
                .phoneNumber(doctor.getPhoneNumber())
                .licenseNumber(doctor.getLicenseNumber())
                .totalPatient(doctor.getPatients().size())
                .build();
        if(includePatients){
            List<PatientResponseDTO> patientResponseDTOS = doctor.getPatients().stream()
                    .map(patient -> PatientResponseDTO.builder()
                            .id(patient.getId())
                            .name(patient.getName())
                            .age(patient.getAge())
                            .dateOfBirth(patient.getDOB())
                            .email(patient.getEmail())
                            .phoneNumber(patient.getPhoneNumber())
                            .diagnosis(patient.getDiagnosis())
                            .admissionDate(patient.getAdmissionDate())
                            .gender(patient.getGender())
                            .doctorId(doctor.getId())
                            .doctorName(doctor.getName())
                            .doctorSpecialization(doctor.getSpecialization())
                            .build()
                    ).collect(Collectors.toList());
            dto.setPatients(patientResponseDTOS);
        }
        return dto;
    }
}
