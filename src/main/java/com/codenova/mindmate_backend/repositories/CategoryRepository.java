package com.codenova.mindmate_backend.repositories;

import com.codenova.mindmate_backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
