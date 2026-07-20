package com.learning.doctor_patient_demo.repository;

import com.learning.doctor_patient_demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByDoctorId(Long doctorId);
    boolean existsByEmail(String email);
    List<Patient> findByDiagnosis(String diagnosis);
}
