package com.example.jsonrelation.controller;

import com.example.jsonrelation.domain.Product;
import com.example.jsonrelation.service.ProductLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductLoader productLoader;

    public ProductController(ProductLoader productLoader) {
        this.productLoader = productLoader;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        var list = new ArrayList<>(productLoader.getAllProducts().values());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        var p = productLoader.getProduct(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }
}

