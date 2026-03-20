package com.example.LeHongPhat.service;

import com.example.LeHongPhat.model.Category;
import com.example.LeHongPhat.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }

    @Override
    public Category create(Category category) {
        return repo.save(category);
    }

    @Override
    public Optional<Category> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Category update(Long id, Category newData) {
        Category c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        c.setName(newData.getName());
        c.setDescription(newData.getDescription());

        return repo.save(c);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}