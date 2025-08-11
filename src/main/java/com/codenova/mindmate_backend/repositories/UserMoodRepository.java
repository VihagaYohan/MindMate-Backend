package com.codenova.mindmate_backend.repositories;

import com.codenova.mindmate_backend.entities.UserMood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMoodRepository extends JpaRepository<UserMood, Long> {
    Page<UserMood> findAllByProfile_Id(Long userId, Pageable pageable);
}
