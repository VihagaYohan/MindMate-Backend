package com.codenova.mindmate_backend.controllers;

import com.codenova.mindmate_backend.dtos.LoginUserRequest;
import com.codenova.mindmate_backend.repositories.UserRepository;
import com.codenova.mindmate_backend.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @Valid @RequestBody LoginUserRequest loginUserRequest
    ) {
        var result = authService.loginUser(loginUserRequest);
        return ResponseEntity.ok().build();
    }
}
