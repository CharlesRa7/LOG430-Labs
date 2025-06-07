package ets.log430.lab.mappers;

import ets.log430.lab.models.dto.ProductAddRequestDto;
import ets.log430.lab.models.product.Product;
import ets.log430.lab.models.product.ProductCategory;
import ets.log430.lab.models.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

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

        return new ProductResponseDto(entity.getId(), entity.getName(), entity.getPrice(),categoryNames);
    }

    public Product productAddRequestDtoToEntity(ProductAddRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return product;
    }
}