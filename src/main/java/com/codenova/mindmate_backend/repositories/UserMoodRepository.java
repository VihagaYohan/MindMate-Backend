package com.codenova.mindmate_backend.repositories;

import com.codenova.mindmate_backend.entities.UserMood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMoodRepository extends JpaRepository<UserMood, Long> {
    List<UserMood> findAllByProfile_Id(Long userId);
}
