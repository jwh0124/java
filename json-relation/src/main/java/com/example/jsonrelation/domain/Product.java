package com.example.jsonrelation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    private UUID id;

    private String name;

    private String manufacturer;

    private List<String> types;
}
