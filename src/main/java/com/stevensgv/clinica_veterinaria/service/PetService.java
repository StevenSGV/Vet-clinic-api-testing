package com.stevensgv.clinica_veterinaria.service;

import com.stevensgv.clinica_veterinaria.dto.PetOwnerDTO;
import com.stevensgv.clinica_veterinaria.model.Pet;
import java.util.ArrayList;
import java.util.List;

import com.stevensgv.clinica_veterinaria.repository.IPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetService implements IPetService {

    private final IPetRepository petRepository;
    
    @Override
    public List<Pet> getPets() {
        List<Pet> petList = petRepository.findAll();
        return petList;
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet findPet(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public void updatePet(Pet pet){
        this.savePet(pet);
    }

    @Override
    public List<Pet> getCanichePets() {
        List<Pet> petList = this.getPets();

        return petList.stream()
                .filter(pet ->
                        pet.getSpecie().equalsIgnoreCase("perro"))
                .filter(pet ->
                        pet.getBreed().equalsIgnoreCase("caniche"))
                .toList();
    }

    @Override
    public List<PetOwnerDTO> getPetOwners() {
        
        List<Pet> petList = this.getPets();
        List<PetOwnerDTO> petOwnerList = new ArrayList<PetOwnerDTO>();
        PetOwnerDTO petOwnerDTO = new PetOwnerDTO();
        
        for (Pet pet : petList) {

            petOwnerDTO.setPetName(pet.getName());
            petOwnerDTO.setSpecie(pet.getSpecie());
            petOwnerDTO.setBreed(pet.getBreed());
            petOwnerDTO.setOwnerName(pet.getOwner().getName());
            petOwnerDTO.setOwnerLastname(pet.getOwner().getLastName());

            petOwnerList.add(petOwnerDTO);
            petOwnerDTO = new PetOwnerDTO();
        }

        return petOwnerList;
    }
}
