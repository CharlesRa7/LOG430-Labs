package ets.log430.lab.mapper;

import ets.log430.lab.entities.Product;
import ets.log430.lab.entities.ProductCategory;
import ets.log430.lab.dto.ProductResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductResponseDto toDto(Product product) {
        List<String> categoryNames = product.getCategories() != null
            ? product.getCategories().stream()
                .map(ProductCategory::getName)
                .collect(Collectors.toList())
            : List.of();

        return new ProductResponseDto(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getStockQuantity(),
            categoryNames
        );
    }
}