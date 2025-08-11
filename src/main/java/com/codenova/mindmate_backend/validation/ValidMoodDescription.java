package com.codenova.mindmate_backend.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MoodDescriptionValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMoodDescription {
    String message() default "Invalid mood description";
    Class<?>[] groups() default {};
    Class <? extends Payload>[] payload() default {};
}
