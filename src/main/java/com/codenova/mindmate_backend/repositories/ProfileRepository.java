package com.codenova.mindmate_backend.repositories;

import com.codenova.mindmate_backend.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository  extends JpaRepository<Profile,Long> {
}
