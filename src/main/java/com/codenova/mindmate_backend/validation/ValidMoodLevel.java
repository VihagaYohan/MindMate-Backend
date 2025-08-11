package com.codenova.mindmate_backend.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MoodLevelValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMoodLevel {
    String message() default "Invalid mood level";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
