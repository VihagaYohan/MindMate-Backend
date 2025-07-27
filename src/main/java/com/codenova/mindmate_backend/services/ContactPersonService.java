package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.dtos.ContactPersonDto;
import com.codenova.mindmate_backend.exceptions.DuplicateRecord;
import com.codenova.mindmate_backend.exceptions.NoResourceException;
import com.codenova.mindmate_backend.mappers.ContactPersonMapper;
import com.codenova.mindmate_backend.mappers.ProfileMapper;
import com.codenova.mindmate_backend.repositories.ContactPersonRepository;
import com.codenova.mindmate_backend.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ContactPersonService {
    private final ContactPersonRepository contactPersonRepository;
    private final ProfileRepository profileRepository;
    private final ProfileService profileService;
    private final ContactPersonMapper contactPersonMapper;
    private final ProfileMapper profileMapper;

    // add contact person
    @Transactional
    public ContactPersonDto addContactPerson(
            ContactPersonDto contactPersonDto,
            Long userId
    ) {
        // check if contact person already exists for the given user id
        var existingRecord = contactPersonRepository.findById(userId).orElse(null);
        if(existingRecord != null) {
            throw new DuplicateRecord("Contact Person already exists");
        }

        /*
        * check if the profile available for given user id
        * at this point most probably it's available because adding contact person occurs after creating a profile
        * */
        var profile = profileRepository.findById(userId).orElseThrow(() ->
                new NoResourceException("Profile not Found"));

        // save contact person
        var contactPerson = contactPersonMapper.toEntity(contactPersonDto);
        contactPerson.setProfile(profile);
        contactPerson.setActive(true);
        contactPersonRepository.save(contactPerson);

        // update the profile to reference the contact person
        if(profile != null) {
            profile.setContactPerson(contactPerson);
            var profileDto = profileMapper.toDto(profile);
            profileService.updateProfile(profileDto);
        }
        return contactPersonMapper.toDto(contactPerson);
    }
}
