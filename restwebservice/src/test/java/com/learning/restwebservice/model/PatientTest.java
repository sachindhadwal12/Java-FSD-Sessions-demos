package com.learning.restwebservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    Patient patient;
    @BeforeEach
    void setUp() {
        patient = new Patient(1,"Gopal","Goa","Headache");
    }

    @AfterEach
    void tearDown() {
        patient = null;
    }


   @Test
    public void shouldReturnNameofPatientWhenPatientNameIsGiven(){
        String name = patient.getName();
        assertEquals("Gopal",name);
    }


}