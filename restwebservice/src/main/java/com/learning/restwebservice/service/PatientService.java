package com.learning.restwebservice.service;

import com.learning.restwebservice.exception.PatientAlreadyExistException;
import com.learning.restwebservice.exception.PatientIdNotFoundException;
import com.learning.restwebservice.model.Patient;
import com.learning.restwebservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements PatientDao {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient savePatient(Patient patient) throws PatientAlreadyExistException {

       Optional<Patient> optionalPatient = repository.findById(patient.getId());
       if(optionalPatient.isPresent()){
           throw new PatientAlreadyExistException("Patient id "+ patient.getId() +" Already exist in DB");
       }
       else {
           return repository.save(patient);
       }
    }

    @Override
    public List<Patient> getAllPatient() {
        return repository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(long id) throws PatientIdNotFoundException {
      return Optional.of(repository.findById(id).orElseThrow(() ->
              new PatientIdNotFoundException("Patient id " + id + " does not found ")));

    }

    @Override
    public void deletePatientById(long id) throws PatientIdNotFoundException {
       Optional<Patient> optionalPatient = repository.findById(id);
       if(optionalPatient.isPresent()){
           repository.deleteById(id);
       }
       else {
           throw  new PatientIdNotFoundException("Patient id  "+ id + " does not found ");
       }
    }

    @Override
    public Patient updatePatient(Patient patient) throws PatientIdNotFoundException {
        Optional<Patient> optionalPatient = repository.findById(patient.getId());
        if(optionalPatient.isPresent()){
            return repository.save(patient);
        }
        else {
            throw new PatientIdNotFoundException("Patient id " + patient.getId()+" does not found ");
        }
    }

    @Override
    public List<Patient> getPatientsByProblem(String problem) {
        return repository.findByProblem(problem);
    }

    @Override
    public List<Patient> searchPatientsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }


}



