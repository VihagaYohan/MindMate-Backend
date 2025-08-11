package com.codenova.mindmate_backend.dtos;

import com.codenova.mindmate_backend.entities.MoodLevel;
import com.codenova.mindmate_backend.entities.MoodType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class UserMoodDto {
    private Long id;
    private Long userId;
    private MoodLevel moodLevel;
    private MoodType moodDescription;
    private String notes;
    private LocalDateTime createdAt;
}
