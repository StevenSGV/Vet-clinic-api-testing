package com.stevensgv.clinica_veterinaria.service;

import com.stevensgv.clinica_veterinaria.model.Owner;
import java.util.List;

import com.stevensgv.clinica_veterinaria.repository.IOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService implements IOwnerService {

    private final IOwnerRepository ownerRepository;

    @Override
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findOwner(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public void updateOwner(Owner owner) {
        this.saveOwner(owner);
    }
}
