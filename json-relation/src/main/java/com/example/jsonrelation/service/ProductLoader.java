package com.example.jsonrelation.service;

import com.example.jsonrelation.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class ProductLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Map<UUID, Product> productMap = new HashMap<>();

    @PostConstruct
    public void loadProducts() {
        try (InputStream is = new ClassPathResource("product.json").getInputStream()) {
            List<Product> products = objectMapper.readValue(is, new TypeReference<List<Product>>() {});
            Map<UUID, Product> map = new HashMap<>();
            for (Product p : products) {
                map.put(p.getId(), p);
            }
            this.productMap = Collections.unmodifiableMap(map);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load products from product.json", e);
        }
    }

    public Product getProduct(UUID id) {
        return productMap.get(id);
    }

    public Map<UUID, Product> getAllProducts() {
        return productMap;
    }
}

