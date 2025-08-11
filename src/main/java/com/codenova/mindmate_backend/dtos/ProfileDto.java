package com.codenova.mindmate_backend.dtos;

import com.codenova.mindmate_backend.entities.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileDto {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    //private ContactPersonDto contactPerson;;
}
