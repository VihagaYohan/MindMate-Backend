package com.codenova.mindmate_backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class MoodLevelValidator implements ConstraintValidator<
        ValidMoodLevel, String> {

    private final Set<String> allowedLevels = Set.of(
            "very_bad",
            "bad",
            "neutral",
            "good",
            "very_good"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return true;
        }
        return allowedLevels.contains(value.toLowerCase());
    }
}
