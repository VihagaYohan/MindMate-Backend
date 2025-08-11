package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.dtos.UserMoodDto;
import com.codenova.mindmate_backend.dtos.requests.AddMoodRequest;
import com.codenova.mindmate_backend.mappers.ProfileMapper;
import com.codenova.mindmate_backend.mappers.UserMoodMapper;
import com.codenova.mindmate_backend.repositories.UserMoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMoodService {
    private final UserMoodRepository userMoodRepository;
    private final UserMoodMapper userMoodMapper;
    private final ProfileMapper profileMapper;
    private final ProfileService profileService;

    // get mood by id

    // get moods by user id

    // add user mood
    public UserMoodDto addUserMood(
            AddMoodRequest userMoodRequest,
            Long userId){

        // check if the profile exists
        var profileDto = profileService.getProfileById(userId);
        var userMood = userMoodMapper.toEntity(userMoodRequest);
        var profile = profileMapper.toEntity(profileDto);
        userMood.setProfile(profile);

        userMoodRepository.save(userMood);
        return userMoodMapper.toDto(userMood);
    }
}
