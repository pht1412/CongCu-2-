package com.example.LeHongPhat.repository;

import com.example.LeHongPhat.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}