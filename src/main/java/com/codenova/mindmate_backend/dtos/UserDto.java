package com.codenova.mindmate_backend.dtos;

import com.codenova.mindmate_backend.entities.Role;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Long id;
    private String email;
    private String password;
    private Role role;
}
