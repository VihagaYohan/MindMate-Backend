package com.codenova.mindmate_backend.mappers;

import com.codenova.mindmate_backend.dtos.UserMoodDto;
import com.codenova.mindmate_backend.dtos.requests.AddMoodRequest;
import com.codenova.mindmate_backend.entities.UserMood;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMoodMapper {

    @Mapping(target="userId", source="profile.id")
    UserMoodDto toDto(UserMood userMood) ;

    @Mapping(target="profile.id", source="userId")
    UserMood toEntity(UserMoodDto userMoodDto);

    UserMood toEntity(AddMoodRequest userMood);
}
