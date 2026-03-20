package com.example.LeHongPhat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(name = "old_price")
    private Double oldPrice;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}