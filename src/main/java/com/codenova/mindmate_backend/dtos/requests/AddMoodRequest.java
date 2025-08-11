package com.codenova.mindmate_backend.dtos.requests;

import com.codenova.mindmate_backend.validation.ValidMoodDescription;
import com.codenova.mindmate_backend.validation.ValidMoodLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddMoodRequest {
    @NotBlank(message = "Mood level is required")
    @ValidMoodLevel
    private String moodLevel;

    @NotBlank(message = "Mood description is required")
    @ValidMoodDescription
    private String moodDescription;

    @Size(max=255, message = "Notes should not exceed 255 characters")
    private String notes;
}
