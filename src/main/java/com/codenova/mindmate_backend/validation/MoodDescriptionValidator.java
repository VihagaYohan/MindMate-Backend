package com.codenova.mindmate_backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class MoodDescriptionValidator implements ConstraintValidator<
        ValidMoodDescription, String> {

    private final Set<String> allowedMoods = Set.of(
            "sad",
            "happy",
            "neutral"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return true;
        }
        return allowedMoods.contains(value.toLowerCase());
    }
}
