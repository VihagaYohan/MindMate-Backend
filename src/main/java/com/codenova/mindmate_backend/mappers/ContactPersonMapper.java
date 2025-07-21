package com.codenova.mindmate_backend.mappers;

import com.codenova.mindmate_backend.dtos.ContactPersonDto;
import com.codenova.mindmate_backend.entities.ContactPerson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactPersonMapper {
    ContactPersonDto toDto (ContactPerson contactPerson);
    ContactPerson toEntity(ContactPersonDto contactPersonDto);
}
