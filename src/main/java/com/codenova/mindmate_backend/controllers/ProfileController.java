package com.codenova.mindmate_backend.controllers;

import com.codenova.mindmate_backend.dtos.ProfileDto;
import com.codenova.mindmate_backend.dtos.requests.CreateProfileRequest;
import com.codenova.mindmate_backend.dtos.responses.SuccessResponse;
import com.codenova.mindmate_backend.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@RestController
@AllArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<SuccessResponse<?>> createProfile(
            @RequestParam(required=true, name="userId") Long userId,
            @RequestBody CreateProfileRequest request
    ) {
        var profileDto = profileService.createProfile(request, userId);
        var successResponse = SuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Profile created")
                .data(profileDto)
                .build();

        return ResponseEntity.ok(successResponse);
    }
}
