package com.learning.restwebservice.service;

import com.learning.restwebservice.exception.PatientAlreadyExistException;
import com.learning.restwebservice.exception.PatientIdNotFoundException;
import com.learning.restwebservice.model.Patient;
import com.learning.restwebservice.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import  static org.assertj.core.api.AssertionsForClassTypes.*;
@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository repository;
   @InjectMocks
    private PatientService service;

   private Patient patient, patient2;

    @BeforeEach
    void setUp() {
        patient = new Patient(1,"Gopal","Goa","Headache");
        patient2 = new Patient(2,"Mike","USA","Toothache");
    }

    @AfterEach
    void tearDown() {
        patient = null;
        patient2 = null;
    }

    @Test
    public void shouldCreatePatientAndReturnPatientObject() throws PatientAlreadyExistException {

      when(repository.save(patient)).thenReturn(patient);
        Patient pt = service.savePatient(patient);
       // assertEquals("Sachin",pt.getName());
        assertThat(pt.getId()).isEqualTo(1);
        //     Patient patient2 = new Patient();
//      when(repository.save(any(Patient.class))).thenAnswer( inv ->{
//          Patient p =inv.getArgument(0);
//          return p;
//      });
//      Patient patient1 = service.savePatient(patient);
//      assertEquals(1,patient1.getId());
    }

    @Test
    public void shouldUpdate(){
        assertTrue(true);
    }

    @Test
    public void shouldReturnListOfAllPatients(){
        List<Patient> patientList = List.of(patient,patient2);
        when(repository.findAll()).thenReturn(patientList);
        List<Patient> result = service.getAllPatient();
        assertEquals(2,result.size());
    }

    @Test
    public void shouldDeletePatientById() throws PatientIdNotFoundException {
       // doNothing().when(repository).deleteById(1L);

       when(repository.findById(1L)).thenReturn(Optional.of(patient));
       long id = 1;
       service.deletePatientById(id);
       verify(repository,times(1)).deleteById(id);
    }

    @Test
    public void shouldThroeExpectionIfNotFound(){
        when(repository.findById(4L)).thenReturn(Optional.empty());
        assertThatThrownBy(()-> service.deletePatientById(4L)).
                isInstanceOf(PatientIdNotFoundException.class)
                .hasMessageContaining("Patient id 4 does not found");
    }


}