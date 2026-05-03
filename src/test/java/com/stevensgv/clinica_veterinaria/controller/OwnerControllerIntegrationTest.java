package com.stevensgv.clinica_veterinaria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stevensgv.clinica_veterinaria.model.Owner;
import com.stevensgv.clinica_veterinaria.repository.IOwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class OwnerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IOwnerRepository ownerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String URL_READ = "/api/owners/";

    @Test
    public void getOwnerByIdTest() throws Exception {
        Owner owner = new Owner(null, "123456", "Steven", "Antonio", "31356");
        ownerRepository.save(owner);

        mockMvc.perform(
                get(URL_READ + owner.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(owner.getName()))
                .andExpect(jsonPath("$.lastName").value(owner.getLastName()));
    }
}
