package com.learning.doctor_patient_demo.controller;

import com.learning.doctor_patient_demo.dto.DoctorRequestDTO;
import com.learning.doctor_patient_demo.dto.DoctorResponseDTO;
import com.learning.doctor_patient_demo.service.DoctorService;
import com.learning.doctor_patient_demo.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final PatientService patientService;


    @PostMapping
    public ResponseEntity<DoctorResponseDTO> createDoctor(@Valid @RequestBody DoctorRequestDTO dto){
        DoctorResponseDTO createdDoctor = doctorService.createDoctor(dto);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors(){
        List<DoctorResponseDTO> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorsBySpecialization(@PathVariable String specialization){
        return ResponseEntity.ok(doctorService.getDoctorsBySpecialization(specialization));
    }

    @GetMapping("/{id}/patients")
    public ResponseEntity<?> getpatientsByDoctorId(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatientsByDoctorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor With id "+ id + " has been deleted");
    }

}
