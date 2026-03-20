package com.example.LeHongPhat.repository;

import com.example.LeHongPhat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Có thể mở rộng sau
    // List<Product> findByNameContaining(String keyword);
}