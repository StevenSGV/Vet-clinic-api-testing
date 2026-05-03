package com.stevensgv.clinica_veterinaria.service;

import com.stevensgv.clinica_veterinaria.dto.PetOwnerDTO;
import com.stevensgv.clinica_veterinaria.model.Pet;

import java.util.List;

public interface IPetService {

    List<Pet> getPets();

    void savePet(Pet pet);

    void deletePet(Long id);

    Pet findPet(Long id);

    void updatePet(Pet pet);

    List<Pet> getCanichePets();
    
    List<PetOwnerDTO> getPetOwners();
    
}
