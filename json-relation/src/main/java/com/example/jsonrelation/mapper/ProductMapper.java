package com.example.jsonrelation.mapper;

import com.example.jsonrelation.domain.Product;
import com.example.jsonrelation.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}

