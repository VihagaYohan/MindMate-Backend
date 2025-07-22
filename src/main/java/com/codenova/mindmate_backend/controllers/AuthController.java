package com.codenova.mindmate_backend.controllers;

import com.codenova.mindmate_backend.config.JwtConfig;
import com.codenova.mindmate_backend.dtos.*;
import com.codenova.mindmate_backend.dtos.requests.LoginUserRequest;
import com.codenova.mindmate_backend.dtos.requests.RegisterUserRequest;
import com.codenova.mindmate_backend.dtos.responses.JwtResponse;
import com.codenova.mindmate_backend.dtos.responses.SuccessResponse;
import com.codenova.mindmate_backend.repositories.UserRepository;
import com.codenova.mindmate_backend.services.AuthService;
import com.codenova.mindmate_backend.services.JwtService;
import com.codenova.mindmate_backend.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final JwtConfig jwtConfig;

    // register user
    @PostMapping("/register")
    public ResponseEntity<SuccessResponse<?>> createUser(
            @Valid @RequestBody RegisterUserRequest registerRequest) {
        var userDto = authService.createUser(registerRequest);
        new SuccessResponse<UserDto>();
        var successResponse = SuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("User has been created")
                .data(userDto)
                .build();

        return ResponseEntity.ok().body(successResponse);
    }

    // user login
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @Valid @RequestBody LoginUserRequest loginUserRequest,
            HttpServletResponse response
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getEmail(),
                        loginUserRequest.getPassword()
                ));

        var userDto = userService.findUserByEmail(loginUserRequest.getEmail());
        var accessToken = jwtService.generateAccessToken(userDto);
        var refreshToken = jwtService.generateRefreshToken(userDto);

        var cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/auth/refresh");
        cookie.setMaxAge(jwtConfig.getRefreshTokenExpiration()); // expire after 7 days
        cookie.setSecure(true);

        // add cookie to response header
        response.addCookie(cookie);
        return ResponseEntity.ok(new JwtResponse(accessToken));
    }

    // refresh access token
    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(
            @CookieValue(value = "refreshToken") String refreshToken
    ) {
        // validate refresh token
        if (!jwtService.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // proceed if the token valid
        var userId = jwtService.getUserIdFromToken(refreshToken);
        var user = userService.findById(userId);
        var accessToken = jwtService.generateAccessToken(user);

        return ResponseEntity.ok(new JwtResponse(accessToken));
    }

    // validate access token
    @PostMapping("/validate")
    public boolean validate(
            @RequestHeader("Authorization") String authHeader
    ) {
        var token = authHeader.replace("Bearer ", "");
        return jwtService.validateToken(token);
    }

    // get current user
    @GetMapping("/me")
    public ResponseEntity<SuccessResponse<?>> getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        // get current user or principle
        var userId = (Long) authentication.getPrincipal();
        var userDto = userService.findById(userId);
        new SuccessResponse();
        var successResponse = SuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Current user logged in")
                .data(userDto)
                .build();

        return ResponseEntity.ok(successResponse);
    }
}
