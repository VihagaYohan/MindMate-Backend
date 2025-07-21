package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.dtos.LoginUserRequest;
import com.codenova.mindmate_backend.exceptions.InvalidCredentialsException;
import com.codenova.mindmate_backend.exceptions.NoResourceException;
import com.codenova.mindmate_backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    // private final AuthenticationManager authenticationManager;

    // login user
/*    public Void loginUser(LoginUserRequest loginUserRequest) {
        var user = userRepository.findByEmail(loginUserRequest.getEmail());
        if(user == null) {
            throw new NoResourceException("User not found");
        }
        // decoding password
        if(!passwordEncoder.matches(loginUserRequest.getPassword(), user.get().getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }
       return null;
    }*/

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       var user =  userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));

       return new User(
               user.getEmail(),
               user.getPassword(),
               Collections.emptyList()
       );
    }
}
