package com.stevensgv.clinica_veterinaria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stevensgv.clinica_veterinaria.model.Owner;
import com.stevensgv.clinica_veterinaria.model.Pet;
import com.stevensgv.clinica_veterinaria.repository.IOwnerRepository;
import com.stevensgv.clinica_veterinaria.repository.IPetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class PetControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private IOwnerRepository ownerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String URL_CREATE = "/api/pets";

    @Test
    public void savePetTest() throws Exception {
        Owner owner = new Owner(null, "123456", "Steven", "Antonio", "31356");
        Owner savedOwner = ownerRepository.save(owner);

        Pet pet = new Pet(null, "Lucas", "Perro", "Pincher", "Café", savedOwner);

        MvcResult result = mockMvc.perform(
                post(URL_CREATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(objectMapper.writeValueAsString(pet))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("Pet created successfully"))
                .andReturn();

        Pet petBD = petRepository.findAll().stream()
                .filter(m -> "Lucas".equals(m.getName()))
                .filter(m -> "Perro".equals(m.getSpecie()))
                .filter(m -> "Pincher".equals(m.getBreed()))
                .filter(m -> "Café".equals(m.getColor()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Pet not found"));

        assertThat(petBD.getId()).isNotNull();
        assertThat(petBD.getName()).isEqualTo("Lucas");
        assertThat(petBD.getSpecie()).isEqualTo("Perro");
        assertThat(petBD.getBreed()).isEqualTo("Pincher");
        assertThat(petBD.getColor()).isEqualTo("Café");
    }
}
