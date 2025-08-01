package com.codenova.mindmate_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoResourceException extends NoSuchElementException {
        public NoResourceException(String message) {
            super(message);
        }
}
