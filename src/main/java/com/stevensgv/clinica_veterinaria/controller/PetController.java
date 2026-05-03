package com.stevensgv.clinica_veterinaria.controller;

import com.stevensgv.clinica_veterinaria.dto.PetOwnerDTO;
import com.stevensgv.clinica_veterinaria.model.Pet;
import java.util.List;

import com.stevensgv.clinica_veterinaria.service.IPetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pets")
public class PetController {

    private final IPetService petService;

    @GetMapping
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @PostMapping
    public String savePet(@Valid @RequestBody Pet pet) {
        petService.savePet(pet);
        return "Pet created successfully";
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "Pet deleted successfully";
    }
    
    @PutMapping
    public String updatePet(@Valid @RequestBody Pet pet) {
        petService.updatePet(pet);
        return "Pet updated successfully";
    }
    
    @GetMapping("/caniches")
    public List<Pet> getCaniches() {
        return petService.getCanichePets();
    }
    
    @GetMapping ("/petOwners")
    public List<PetOwnerDTO> getPetOwners () {
        return petService.getPetOwners();
    }

}
