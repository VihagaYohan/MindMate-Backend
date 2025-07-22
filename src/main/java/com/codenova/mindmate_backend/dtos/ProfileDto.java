package com.codenova.mindmate_backend.dtos;

import com.codenova.mindmate_backend.entities.ContactPerson;
import com.codenova.mindmate_backend.entities.Gender;
import com.codenova.mindmate_backend.entities.User;
import lombok.Data;

@Data
public class ProfileDto {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private ContactPerson contactPerson;;
}
