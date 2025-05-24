package ets.log430.lab.mappers;

import ets.log430.lab.dto.ProductAddRequestDto;
import ets.log430.lab.dto.ProductCategoryDto;
import ets.log430.lab.entities.Product;
import ets.log430.lab.entities.ProductCategory;
import ets.log430.lab.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductResponseDto productToResponseDto(Product entity) {
        if (entity == null) {
            return null;
        }

        List<String> categoryNames = entity.getCategories()
                .stream()
                .map(ProductCategory::getName)
                .toList();

        return new ProductResponseDto(entity.getId(), entity.getName(), entity.getPrice(), entity.getStockQuantity(),categoryNames);
    }

    public Product productAddRequestDtoToEntity(ProductAddRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());

        return product;
    }
}