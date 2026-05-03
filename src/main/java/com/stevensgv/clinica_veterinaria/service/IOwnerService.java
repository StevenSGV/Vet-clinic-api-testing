package com.stevensgv.clinica_veterinaria.service;

import com.stevensgv.clinica_veterinaria.model.Owner;

import java.util.List;

public interface IOwnerService {

    List<Owner> getOwners();

    void saveOwner(Owner owner);

    void deleteOwner(Long id);

    Owner findOwner(Long id);

    void updateOwner(Owner owner);
    
}
