package com.learning.restwebservice.repository;

import com.learning.restwebservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findByProblem(String problem);
    List<Patient> findByNameContainingIgnoreCase(String name);
}
