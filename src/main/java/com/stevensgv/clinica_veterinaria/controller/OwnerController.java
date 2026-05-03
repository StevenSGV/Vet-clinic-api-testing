package com.stevensgv.clinica_veterinaria.controller;

import com.stevensgv.clinica_veterinaria.model.Owner;
import java.util.List;

import com.stevensgv.clinica_veterinaria.service.IOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/owners")
public class OwnerController {

    private final IOwnerService ownerService;
     
    @GetMapping
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerService.findOwner(id);
    }
    
    @PostMapping
    public String saveOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
        
        return "Owner created successfully";
    }
    
    @DeleteMapping ("/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return "Owner deleted successfully";
    }
    
    @PutMapping
    public Owner updateOwner(@RequestBody Owner owner) {
        ownerService.updateOwner(owner);
        return ownerService.findOwner(owner.getId());
    }
}
