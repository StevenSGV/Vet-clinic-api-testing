package com.stevensgv.clinica_veterinaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetOwnerDTO {
    
    private String petName;
    private String specie;
    private String breed;
    private String ownerName;
    private String ownerLastname;
}
