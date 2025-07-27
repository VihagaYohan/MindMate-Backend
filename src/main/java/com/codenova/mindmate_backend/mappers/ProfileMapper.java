package com.codenova.mindmate_backend.mappers;

import com.codenova.mindmate_backend.dtos.ProfileDto;
import com.codenova.mindmate_backend.dtos.requests.CreateProfileRequest;
import com.codenova.mindmate_backend.entities.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    @Mapping(source = "user.id", target="userId")
    ProfileDto toDto(Profile profile);

    Profile toEntity(ProfileDto profileDto);

    // from request to entity
    Profile toEntity(CreateProfileRequest request);
}
