package com.learning.restwebservice.service;

import com.learning.restwebservice.exception.PatientAlreadyExistException;
import com.learning.restwebservice.exception.PatientIdNotFoundException;
import com.learning.restwebservice.model.Patient;

import java.util.List;
import java.util.Optional;


public interface PatientDao {
    public Patient savePatient(Patient patient) throws PatientAlreadyExistException;
    public List<Patient> getAllPatient();
    public Optional<Patient> getPatientById(long id) throws PatientIdNotFoundException;
    public void deletePatientById(long id) throws PatientIdNotFoundException;
    public Patient updatePatient(Patient patient) throws PatientIdNotFoundException;
    // custom methods
    public List<Patient> getPatientsByProblem(String problem);
    public List<Patient> searchPatientsByName(String name);

}
