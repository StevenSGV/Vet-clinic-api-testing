package com.stevensgv.clinica_veterinaria.repository;

import com.stevensgv.clinica_veterinaria.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long>{
    
}
