package com.codenova.mindmate_backend.controllers;

import com.codenova.mindmate_backend.dtos.RegisterUserRequest;
import com.codenova.mindmate_backend.dtos.SuccessResponse;
import com.codenova.mindmate_backend.dtos.UserDto;
import com.codenova.mindmate_backend.entities.User;
import com.codenova.mindmate_backend.repositories.UserRepository;
import com.codenova.mindmate_backend.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<SuccessResponse<?>> getAllUsers() {
        var usersList = userService.findAll();
        var successResponse = new SuccessResponse<List<UserDto>>().builder()
                .status(HttpStatus.OK.value())
                .message("All users found")
                .data(usersList)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<?>> getUserById(
            @PathVariable("id") Long id) {
        var user = userService.findById(id);
        var successResponse = new SuccessResponse<UserDto>().builder()
                .status(HttpStatus.OK.value())
                .message("User with id " + id + " found")
                .data(user)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }
}
