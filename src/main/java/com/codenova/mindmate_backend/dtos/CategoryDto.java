package com.codenova.mindmate_backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.codenova.mindmate_backend.entities.Category}
 */
@Data
public class CategoryDto implements Serializable {
    Long id;
    @NotBlank(message = "Category title is required")
    @Size(max=255, message = "Category must be less than 255 characters")
    String title;

    @NotBlank(message = "Category background color is required")
    @Size(max = 20, message = "Category background color must be less than 20 characters")
    String backgroundColor;

    @NotBlank(message = "Category image URL is required")
    @Size(max = 255, message = "Category icon image URL must be less than 255 characters")
    String imageUrl;

    Boolean isActive;
}