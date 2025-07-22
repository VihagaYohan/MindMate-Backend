package com.codenova.mindmate_backend.mappers;

import com.codenova.mindmate_backend.dtos.RegisterUserRequest;
import com.codenova.mindmate_backend.dtos.UserDto;
import com.codenova.mindmate_backend.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(RegisterUserRequest registerUserRequest);
}
