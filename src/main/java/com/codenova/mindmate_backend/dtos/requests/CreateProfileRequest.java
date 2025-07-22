package com.codenova.mindmate_backend.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class CreateProfileRequest {
    @NotBlank(message = "First name is required")
    @Size(max=255, message = "First name should not exceed 255 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 255, message = "Last name should not exceed 255 characters")
    private String lastName;

    @NotBlank(message = "Gender is required")
    @Size(max = 20, message = "Gender should not exceed 20 characters")
    private String gender;

    @NotBlank(message = "Date of birth is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
}
