package com.stevensgv.clinica_veterinaria.controller;

import com.stevensgv.clinica_veterinaria.dto.PetOwnerDTO;
import com.stevensgv.clinica_veterinaria.model.Owner;
import com.stevensgv.clinica_veterinaria.model.Pet;
import com.stevensgv.clinica_veterinaria.service.IPetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(PetController.class)
public class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPetService petService;

    @Test
    public void getPetOwners() throws Exception {
        PetOwnerDTO petOwnerDTO = new PetOwnerDTO("Lucas",
                "Perro", "Pincher", "Steven", "Gómez");

        when(petService.getPetOwners()).thenReturn(List.of(petOwnerDTO));

        mockMvc.perform(
                get("/api/pets/petOwners")
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].petName").value("Lucas"))
                .andExpect(jsonPath("$[0].ownerName").value("Steven"))
                .andExpect(jsonPath("$[0].ownerLastname").value("Gómez"));
    }

    @Test
    public void getCaniches() throws Exception {
        Owner firstOwner = new Owner(null, "123456", "Steven", "Antonio", "31356");
        Owner secondOwner = new Owner(null, "123456", "Ana", "Sofia", "31356");

        Pet firstPet = new Pet(1L, "Lucas", "Perro", "Caniche", "Café", firstOwner);
        Pet secondPet = new Pet(2L, "Atenea", "Perro", "Caniche", "Café", secondOwner);

        when(petService.getCanichePets()).thenReturn(List.of(firstPet, secondPet));

        mockMvc.perform(
                get("/api/pets/caniches")
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Lucas"))
                .andExpect(jsonPath("$[1].name").value("Atenea"));
    }
}