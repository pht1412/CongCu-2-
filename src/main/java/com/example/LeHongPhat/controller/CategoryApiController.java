package com.example.LeHongPhat.controller;

import com.example.LeHongPhat.model.Category;
import com.example.LeHongPhat.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryApiController {

    private final CategoryService service;

    public CategoryApiController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Category create(@RequestBody Category c) {
        return service.create(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        Category c = service.getById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return ResponseEntity.ok(c);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}