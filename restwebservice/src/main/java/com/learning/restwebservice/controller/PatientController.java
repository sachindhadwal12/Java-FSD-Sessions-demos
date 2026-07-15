package com.learning.restwebservice.controller;

import com.learning.restwebservice.customresponse.ResponseHandler;
import com.learning.restwebservice.exception.PatientAlreadyExistException;
import com.learning.restwebservice.exception.PatientIdNotFoundException;
import com.learning.restwebservice.model.Patient;
import com.learning.restwebservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {

    private final PatientService service;
    @Value("${app.name}")
    String name;

    public PatientController(PatientService service) {
        this.service = service;
    }
// save Patient
    @PostMapping
    public ResponseEntity<?> savePatient(@RequestBody @Valid  Patient patient) throws PatientAlreadyExistException {


        System.out.println("Name is "+ name);
        return ResponseHandler.generateResponse("Patient saved Successfully",
                HttpStatus.CREATED,service.savePatient(patient), LocalDateTime.now());





    }
// Get all Patient
    @GetMapping
    public ResponseEntity<?> getAllPatients(){
        return new ResponseEntity<>(service.getAllPatient(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable long id) throws PatientIdNotFoundException {

        return ResponseHandler.generateResponse("Fetched Patient data",HttpStatus.OK,service.getPatientById(id),LocalDateTime.now());

          //  return new ResponseEntity<>(service.getPatientById(id),HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientById(@PathVariable long id) throws PatientIdNotFoundException {

            service.deletePatientById(id);
            return new ResponseEntity<>("Patient id "+ id + "deleted successfully",HttpStatus.OK);

    }

    @PutMapping
public  ResponseEntity<?> updatePatient(@RequestBody Patient patient) throws PatientIdNotFoundException {

            return new ResponseEntity<>(service.updatePatient(patient),HttpStatus.OK);


    }
// custom endpoints

    @GetMapping("/disease/{problem}")
    public ResponseEntity<?> getPatientsByProblem(@PathVariable String problem){

        return new ResponseEntity<>(service.getPatientsByProblem(problem),HttpStatus.OK);

    }


    @GetMapping("/search")
   public ResponseEntity<?> searchPatientByName(@RequestParam String name){
        return new ResponseEntity<>(service.searchPatientsByName(name),HttpStatus.OK);
    }




}
