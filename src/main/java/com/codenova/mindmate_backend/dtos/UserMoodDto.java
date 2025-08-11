package com.codenova.mindmate_backend.dtos;

import com.codenova.mindmate_backend.entities.MoodLevel;
import com.codenova.mindmate_backend.entities.MoodType;
import lombok.Data;

@Data
public class UserMoodDto {
    private Long id;
    private Long userId;
    private MoodLevel moodLevel;
    private MoodType moodDescription;
    private String notes;
}
