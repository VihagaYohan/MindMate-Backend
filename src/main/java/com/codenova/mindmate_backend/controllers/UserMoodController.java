package com.codenova.mindmate_backend.controllers;

import com.codenova.mindmate_backend.dtos.requests.AddMoodRequest;
import com.codenova.mindmate_backend.dtos.responses.SuccessResponse;
import com.codenova.mindmate_backend.services.UserMoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user-moods")
public class UserMoodController {
    private final UserMoodService userMoodService;

    @PostMapping
    public ResponseEntity<SuccessResponse<?>>addUserMood(
            @RequestParam(required = true, name="userId")Long userId,
            @RequestBody AddMoodRequest request
            ) {
        var userMood =  userMoodService.addUserMood(request, userId);
        var successResponse = SuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("User mood added successfully")
                .data(userMood)
                .build();

        return ResponseEntity.ok(successResponse);
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<?>> getUserMoods(
            @RequestParam(required = true, name="userId") Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var userMoodList = userMoodService.getUserMoods(userId, page, size);
        var successResponse = SuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("User moods retrieved successfully")
                .data(userMoodList)
                .build();

        return ResponseEntity.ok(successResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<?>>getUserMoodById(
            @PathVariable Long id
    ) {
        var userMood = userMoodService.getUserMoodById(id);
        var successResponse = SuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("User mood retrieved successfully")
                .data(userMood)
                .build();

        return ResponseEntity.ok(successResponse);
    }
}
