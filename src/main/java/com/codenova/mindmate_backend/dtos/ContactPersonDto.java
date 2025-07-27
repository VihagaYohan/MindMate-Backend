package com.codenova.mindmate_backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContactPersonDto {
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max=255, message="First name must be less than 255 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 255, message = "Last name must be less than 255 characters")
    private String lastName;

    @NotBlank(message = "Mobile phone number is required")
    @Size(max=20, message = "Mobile phone must be less than 20 characters")
    private String mobileNumber;
}
