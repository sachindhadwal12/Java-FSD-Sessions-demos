package com.learning.restwebservice.controller;

import com.learning.restwebservice.exception.PatientAlreadyExistException;
import com.learning.restwebservice.model.Patient;
import com.learning.restwebservice.service.PatientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private PatientService service;


    @InjectMocks
    private PatientController controller;

    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient(1,"Gopal","Goa","Headache");
        mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
    }

    @AfterEach
    void tearDown() {
        patient = null;
    }

    @Test
    public void whenPatientObjectIsCreatedShouldReturnPatient() throws Exception {
        Mockito.when(service.savePatient(Mockito.any())).thenReturn(patient);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/patients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
                    Mockito.verify(service,Mockito.times(1)).savePatient(Mockito.any());


    }

    @Test
    public void shouldReturnListOfPatients() throws Exception {
        List<Patient> patientList = List.of(patient);
        Mockito.when(service.getAllPatient()).thenReturn(patientList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/patients")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(patientList)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }








    public static String asJsonString(final Object o){
        try{
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}