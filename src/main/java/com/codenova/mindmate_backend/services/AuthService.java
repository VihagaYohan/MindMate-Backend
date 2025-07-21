package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.dtos.LoginUserRequest;
import com.codenova.mindmate_backend.exceptions.InvalidCredentialsException;
import com.codenova.mindmate_backend.exceptions.NoResourceException;
import com.codenova.mindmate_backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // login user
    public Void loginUser(LoginUserRequest loginUserRequest) {
        var user = userRepository.findByEmail(loginUserRequest.getEmail());
        if(user == null) {
            throw new NoResourceException("User not found");
        }
        // decoding password
        if(!passwordEncoder.matches(loginUserRequest.getPassword(), user.get().getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }
       return null;
    }
}
