package com.codenova.mindmate_backend.controllers;

import com.codenova.mindmate_backend.dtos.ContactPersonDto;
import com.codenova.mindmate_backend.dtos.responses.SuccessResponse;
import com.codenova.mindmate_backend.services.ContactPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/contact-persons")
public class ContactPersonController {
    private final ContactPersonService contactPersonService;

    @PostMapping("")
    public ResponseEntity<SuccessResponse<?>>addContactPerson(
            @RequestBody ContactPersonDto request,
            @RequestParam(required=true, name="userId") Long userId
    ) {
        var contactPersonDto = contactPersonService.addContactPerson(request, userId);
        var successResponse = SuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .data(contactPersonDto)
                .message("Added contact person successfully")
                .build();

        return ResponseEntity.ok(successResponse);
    }
}
