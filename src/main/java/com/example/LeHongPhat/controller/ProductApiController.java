package com.example.LeHongPhat.controller;

import com.example.LeHongPhat.model.Product;
import com.example.LeHongPhat.model.Category;
import com.example.LeHongPhat.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductApiController {

    private final ProductService productService;

    // ✅ Constructor Injection
    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    // ================= GET ALL =================
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // ================= CREATE =================
    @PostMapping
    public Product createProduct(@RequestBody Map<String, Object> body) {

        Product product = new Product();
        product.setName((String) body.get("name"));
        product.setPrice(Double.parseDouble(body.get("price").toString()));
        product.setDescription((String) body.get("description"));

        Long categoryId = body.get("categoryId") != null
                ? Long.parseLong(body.get("categoryId").toString())
                : null;

        return productService.addProduct(product, categoryId);
    }

    // ================= GET BY ID =================
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found :: " + id));
        return ResponseEntity.ok(product);
    }

    // ================= UPDATE =================
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
            @RequestBody Map<String, Object> body) {

        Product product = new Product();
        product.setName((String) body.get("name"));
        product.setPrice(Double.parseDouble(body.get("price").toString()));
        product.setDescription((String) body.get("description"));

        Long categoryId = body.get("categoryId") != null
                ? Long.parseLong(body.get("categoryId").toString())
                : null;

        Product updated = productService.updateProduct(id, product, categoryId);

        return ResponseEntity.ok(updated);
    }

    // ================= DELETE =================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}