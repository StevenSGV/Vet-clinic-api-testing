package com.stevensgv.clinica_veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Pattern(regexp = "\\d{8}", message = "The ID card must contain exactly 8 numeric digits.")
    private String dni;

    @NotBlank(message = "Name is required")
    @Size(max = 60, message = "Name must not exceed 60 characters")
    private String name;
    private String lastName;
    private String phoneNumber;
}
