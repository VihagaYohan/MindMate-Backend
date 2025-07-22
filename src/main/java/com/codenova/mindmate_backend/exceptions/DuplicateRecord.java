package com.codenova.mindmate_backend.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateRecord extends DataIntegrityViolationException {
    public DuplicateRecord(String message) {
        super(message);
    }
}
