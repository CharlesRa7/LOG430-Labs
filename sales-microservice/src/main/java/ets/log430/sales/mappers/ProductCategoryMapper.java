package ets.log430.sales.mappers;

import ets.log430.sales.models.dto.product.ProductCategoryDto;
import ets.log430.sales.models.product.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper {

    public ProductCategoryDto toDto(ProductCategory entity) {
        if (entity == null) {
            return null;
        }
        return new ProductCategoryDto(entity.getId(), entity.getName());
    }

    public ProductCategory toEntity(ProductCategoryDto dto) {
        if (dto == null) {
            return null;
        }
        ProductCategory category = new ProductCategory();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
