package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.dtos.RegisterUserRequest;
import com.codenova.mindmate_backend.dtos.UserDto;
import com.codenova.mindmate_backend.exceptions.DuplicateRecord;
import com.codenova.mindmate_backend.exceptions.NoResourceException;
import com.codenova.mindmate_backend.mappers.UserMapper;
import com.codenova.mindmate_backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
        private final UserRepository userRepository;
        @Autowired
        private final UserMapper userMapper;

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

        // register user
        public UserDto createUser(RegisterUserRequest registerUserRequest) {
                // check already existing user with same email
                if(userRepository.existsByEmail(registerUserRequest.getEmail())) {
                        throw new DuplicateRecord("Email already exists");
                }
                var user = userMapper.toEntity(registerUserRequest);

                userRepository.save(user);
                var userDto = userMapper.toDto(user);
                return userDto;
        }
}
