package com.example.LeHongPhat.service;

import com.example.LeHongPhat.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAll();

    Category create(Category category);

    Optional<Category> getById(Long id);

    Category update(Long id, Category category);

    void delete(Long id);
}