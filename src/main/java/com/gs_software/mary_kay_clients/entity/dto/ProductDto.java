package com.gs_software.mary_kay_clients.entity.dto;

import com.gs_software.mary_kay_clients.entity.Product;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer stock,
        String image
) {
    public ProductDto(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getImage());
    }
}
