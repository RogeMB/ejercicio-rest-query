package com.salesianostriana.dam.restquery.dto;

import com.salesianostriana.dam.restquery.model.Product;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ProductDto (Long id, String productName, LocalDate releaseDate, double price, boolean available) {
    public static ProductDto of(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .releaseDate(product.getReleaseDate())
                .price(product.getPrice())
                .available(product.isAvailable())
                .build();
    }
}