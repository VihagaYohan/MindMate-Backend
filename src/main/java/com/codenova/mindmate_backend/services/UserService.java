package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.dtos.UserDto;
import com.codenova.mindmate_backend.exceptions.NoResourceException;
import com.codenova.mindmate_backend.mappers.UserMapper;
import com.codenova.mindmate_backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
        private final UserRepository userRepository;
        private final UserMapper userMapper;
        private final PasswordEncoder passwordEncoder;

        // get all users
        public Iterable<UserDto>findAll() {
            return userRepository.findAll()
                    .stream()
                    .map(user -> userMapper.toDto(user))
                    .toList();
        }

        // get user by id
        public UserDto findById(Long id) {
                var user = userRepository.findById(id).orElseThrow(() ->
                        new NoResourceException(String.format("User with id %s not found", id)));

                var userDto = userMapper.toDto(user);
                return userDto;
        }

        // find user by email
        public UserDto findUserByEmail(String email) {
                var user = userRepository.findByEmail(email).orElseThrow(() ->
                        new NoResourceException(String.format("User with email %s not found", email)));

                var userDto = userMapper.toDto(user);
                return userDto;
        }
}
