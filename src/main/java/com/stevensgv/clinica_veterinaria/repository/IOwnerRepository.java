package com.stevensgv.clinica_veterinaria.repository;

import com.stevensgv.clinica_veterinaria.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends JpaRepository <Owner, Long>{
    
}
