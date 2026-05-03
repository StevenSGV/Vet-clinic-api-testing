package com.stevensgv.clinica_veterinaria.service;

import com.stevensgv.clinica_veterinaria.model.Owner;
import com.stevensgv.clinica_veterinaria.model.Pet;
import com.stevensgv.clinica_veterinaria.repository.IPetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private IPetRepository petRepository;

    @InjectMocks
    private PetService petService;

    @Test
    public void savePetTest() {
        Owner owner = new Owner(null, "123456", "Steven", "Antonio", "31356");
        Pet pet = new Pet(null, "Lucas", "Perro", "Pincher", "Café", owner);

        petService.savePet(pet);

        verify(petRepository).save(pet);
        verifyNoMoreInteractions(petRepository);
    }

    @Test
    public void getPetTest() {
        Owner firstOwner = new Owner(null, "123456", "Steven", "Antonio", "31356");
        Owner secondOwner = new Owner(null, "123456", "Ana", "Sofia", "31356");

        Pet firstPet = new Pet(1L, "Lucas", "Perro", "Pincher", "Cafe", firstOwner);
        Pet secondPet = new Pet(2L, "Atenea", "Perro", "Labrador", "Gris", secondOwner);

        when(petRepository.findAll()).thenReturn(List.of(firstPet, secondPet));

        List<Pet> petList = petService.getPets();

        assertNotNull(petList);
        assertEquals(2, petList.size());
        assertEquals(1L, petList.get(0).getId());
        assertEquals("Lucas", petList.get(0).getName());
        assertEquals(2L, petList.get(1).getId());
        assertEquals("Atenea", petList.get(1).getName());

        verify(petRepository).findAll();
        verifyNoMoreInteractions(petRepository);
    }
}
