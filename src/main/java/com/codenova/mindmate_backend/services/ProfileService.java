package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.dtos.ProfileDto;
import com.codenova.mindmate_backend.dtos.requests.CreateProfileRequest;
import com.codenova.mindmate_backend.exceptions.DuplicateRecord;
import com.codenova.mindmate_backend.exceptions.NoResourceException;
import com.codenova.mindmate_backend.mappers.ProfileMapper;
import com.codenova.mindmate_backend.repositories.ProfileRepository;
import com.codenova.mindmate_backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final UserRepository userRepository;

    // ger profile by id
    public ProfileDto getProfileById(Long id) {
       var profile = profileRepository.findById(id)
               //.orElse(null);
               .orElseThrow(() -> new NoResourceException("Profile not found"));
        return profileMapper.toDto(profile);
    }

    // add new profile
    public ProfileDto createProfile(
        CreateProfileRequest profileRequest,
            Long userId) {
        // load user
        var user = userRepository.findById(userId).orElseThrow(() ->
                 new NoResourceException("User not found"));

        // check for duplicate profile with same id
        var userProfile = profileRepository.findById(userId);
        if(userProfile.isPresent()) {
            throw new DuplicateRecord("Profile already exists");
        }

        var profile = profileMapper.toEntity(profileRequest);
        profile.setUser(user);
        profile.setIsActive(true);
        profileRepository.save(profile);

        return profileMapper.toDto(profile);
    }

    // update profile
    public ProfileDto updateProfile(ProfileDto profileDto) {
        var profile = profileMapper.toEntity(profileDto);
        profileRepository.save(profile);
        return profileMapper.toDto(profile);
    }
}
