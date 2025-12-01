package com.example.jsonrelation.mapper;

import com.example.jsonrelation.domain.Device;
import com.example.jsonrelation.domain.Product;
import com.example.jsonrelation.dto.DeviceDto;
import com.example.jsonrelation.dto.ProductDto;
import com.example.jsonrelation.service.EntityMapper;
import com.example.jsonrelation.service.ProductLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class DeviceMapper implements EntityMapper<DeviceDto, Device> {

    @Autowired
    ProductLoader productLoader;

    @Autowired
    ProductMapper productMapper;

    @Mapping(target = "product", source = "productId", qualifiedByName = "productId")
    public abstract DeviceDto toDto(Device s);

    @Named("productId")
    protected ProductDto toDtoProductId(UUID productId) {
        if (productId == null) return null;
        Product p = productLoader.getProduct(productId);
        return p == null ? null : productMapper.toDto(p);
    }

    @Mapping(target = "productId", source = "product.id", qualifiedByName = "productIdToEntity")
    public abstract Device toEntity(DeviceDto dto);

    @Named("productIdToEntity")
    protected UUID toEntityProduct(UUID productId) {
        if (productId == null) return null;
        Product p = productLoader.getProduct(productId);
        if (p == null) {
            throw new IllegalArgumentException("Unknown product id: " + productId);
        }
        return productId;
    }
}
