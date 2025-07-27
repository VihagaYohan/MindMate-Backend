package com.codenova.mindmate_backend.repositories;

import com.codenova.mindmate_backend.entities.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {
}
