package com.example.LeHongPhat.service;

import com.example.LeHongPhat.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Product addProduct(Product product, Long categoryId);

    Optional<Product> getProductById(Long id);

    Product updateProduct(Long id, Product product, Long categoryId);

    void deleteProductById(Long id);
}