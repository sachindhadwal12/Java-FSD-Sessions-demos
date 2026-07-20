package com.learning.doctor_patient_demo.repository;

import com.learning.doctor_patient_demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Doctor> findByEmail(String email);
    List<Doctor> findBySpecialization(String specialization);
    boolean existsByEmail(String email);

    // custom JPQL
    @Query("SELECT DISTINCT d FROM Doctor d LEFT JOIN FETCH d.patients WHERE d.id = :id")
    Optional<Doctor> findByIdWithPatients(Long id);
}
