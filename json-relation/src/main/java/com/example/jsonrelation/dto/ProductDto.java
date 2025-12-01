package com.example.jsonrelation.dto;

import com.example.jsonrelation.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductDto {

    private UUID id;

    private String name;

    private String manufacturer;

    private List<String> types;
}
