package com.stevensgv.clinica_veterinaria.model;

import com.stevensgv.clinica_veterinaria.validation.ValidSpecie;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 60, message = "Name must not exceed 60 characters")
    private String name;

    @NotBlank(message = "Specie is required")
    @Size(max = 40, message = "Specie must not exceed 40 characters")
    @ValidSpecie(value = {"Dog", "Cat", "Bird"}, message = "Invalid specie, the options are dog, cat and bird")
    private String specie;

    @Size(max = 40, message = "Breed must not exceed 40 characters")
    private String breed;

    @Size(max = 40, message = "Color must not exceed 40 characters")
    private String color;
    
    @OneToOne
    @JoinColumn(name = "id_owner")
    @Valid
    private Owner owner;
}
