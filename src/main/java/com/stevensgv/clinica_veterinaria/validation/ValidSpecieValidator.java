package com.stevensgv.clinica_veterinaria.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidSpecieValidator implements ConstraintValidator<ValidSpecie, String> {

    private Set valid;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isBlank()) {
            return true;
        }

        return valid.contains(s.toLowerCase(Locale.ROOT));
    }

    @Override
    public void initialize(ValidSpecie constraintAnnotation) {
        this.valid = Arrays.stream(constraintAnnotation.value())
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(Collectors.toSet());
    }
}
