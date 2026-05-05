package com.stevensgv.clinica_veterinaria.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidSpecieValidator.class)
public @interface ValidSpecie {

    String message() default "{pet.specie.invalid}";

    Class[] groups() default {};
    Class[] payload() default {};

    String[] value();
}
