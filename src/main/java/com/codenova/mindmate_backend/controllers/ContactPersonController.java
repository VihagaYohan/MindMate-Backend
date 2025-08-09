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

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<?>> getContactPersonById(
            @PathVariable("id") Long id
    ) {
        var contactPersonDto = contactPersonService.getContactPerson(id);
        new SuccessResponse<ContactPersonDto>();
        var successResponse = SuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Contact person successfully retrieved")
                .data(contactPersonDto)
                .build();
        return ResponseEntity.ok(successResponse);
    }

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
