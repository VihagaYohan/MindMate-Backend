package com.codenova.mindmate_backend.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.codenova.mindmate_backend.entities.Category}
 */
@Value
public class CategoryDto implements Serializable {
    Long id;
    String title;
    String backgroundColor;
}