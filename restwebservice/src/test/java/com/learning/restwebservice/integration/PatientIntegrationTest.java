package com.learning.restwebservice.integration;

import com.learning.restwebservice.model.Patient;
import com.learning.restwebservice.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(properties = {
        "app.name=integration-test",
        "spring.autoconfigure.exclude=" +
                "org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration," +
                "org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration," +
                "org.springframework.boot.data.jpa.autoconfigure.DataJpaRepositoriesAutoConfiguration"
})
@AutoConfigureMockMvc
public class PatientIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PatientRepository repository;

    private Patient patient, patient1;

    @BeforeEach
    public void setUp(){
        patient = new Patient(1,"Gopal","Goa","Headache");
        patient1 = new Patient(2,"Mike","USA","Toothache");
    }

    @Test
    public void getAllPatientsReturnListOfPatientFromRepository() throws Exception {
        given(repository.findAll()).willReturn(List.of(patient, patient1));
        mockMvc.perform(get("/api/v1/patients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("Gopal"))
                .andExpect(jsonPath("$[1].name").value("Mike"));
    }

    /*
     * POST /api/v1/patients — creates a new patient.
     * The repository is mocked so that no patient with id 1 exists yet
     * (findById returns empty), which lets PatientService.savePatient go
     * down the "save" branch instead of throwing PatientAlreadyExistException.
     * We send a valid JSON body (so @Valid passes) and assert that the
     * endpoint returns 201 CREATED and that the response is wrapped in the
     * ResponseHandler envelope: a "message" field plus the saved patient
     * under "Data".
     */
    @Test
    public void shouldCreatePatientAndReturnCreatedResponseEnvelope() throws Exception {
        // No existing patient with this id -> save path is taken.
        given(repository.findById(1L)).willReturn(Optional.empty());
        // The repository echoes back the patient it is asked to persist.
        given(repository.save(any(Patient.class))).willReturn(patient);

        String requestBody = "{\"id\":1,\"name\":\"Gopal\",\"address\":\"Goa\",\"problem\":\"Headache\"}";

        mockMvc.perform(post("/api/v1/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Patient saved Successfully"))
                .andExpect(jsonPath("$.Data.id").value(1))
                .andExpect(jsonPath("$.Data.name").value("Gopal"));
    }

    /*
     * GET /api/v1/patients/{id} — fetches a single patient by id.
     * The repository is mocked to return the patient for id 1, so the
     * service resolves it successfully. We assert 200 OK and that the body
     * uses the ResponseHandler envelope: the "Fetched Patient data" message
     * and the patient details nested under "Data".
     */
    @Test
    public void shouldReturnPatientByIdWrappedInResponseEnvelope() throws Exception {
        given(repository.findById(1L)).willReturn(Optional.of(patient));

        mockMvc.perform(get("/api/v1/patients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Fetched Patient data"))
                .andExpect(jsonPath("$.Data.name").value("Gopal"))
                .andExpect(jsonPath("$.Data.address").value("Goa"));
    }

    /*
     * GET /api/v1/patients/{id} for a missing id — exercises the error path.
     * The repository returns empty, so PatientService throws
     * PatientIdNotFoundException, which GlobalExceptionHandler translates
     * into a 404 NOT FOUND with the exception message as the plain-text body.
     * This verifies that the exception-handling advice is wired into the
     * request flow end to end.
     */
    @Test
    public void shouldReturn404WhenPatientIdDoesNotExist() throws Exception {
        given(repository.findById(99L)).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/patients/99"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Patient id 99 does not found")));
    }

    /*
     * DELETE /api/v1/patients/{id} — deletes an existing patient.
     * The repository is mocked so that findById(1) returns the patient,
     * letting PatientService.deletePatientById proceed to deleteById
     * instead of throwing PatientIdNotFoundException. We assert 200 OK and
     * that the confirmation message contains the deleted id, and we verify
     * that the repository's deleteById was actually invoked exactly once.
     */
    @Test
    public void shouldDeletePatientByIdAndReturnConfirmationMessage() throws Exception {
        // Patient exists -> delete path is taken.
        given(repository.findById(1L)).willReturn(Optional.of(patient));

        mockMvc.perform(delete("/api/v1/patients/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Patient id 1")));

        // Confirm the repository was told to delete this id.
        org.mockito.Mockito.verify(repository, org.mockito.Mockito.times(1)).deleteById(1L);
    }
}
