package ets.log430.lab.services.product;

import ets.log430.lab.models.dto.product.ProductCategoryDto;
import ets.log430.lab.models.product.ProductCategory;
import ets.log430.lab.mappers.ProductCategoryMapper;
import ets.log430.lab.repositories.product.ProductCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository categoryRepository;
    private final ProductCategoryMapper categoryMapper;

    public ProductCategoryService(ProductCategoryRepository categoryRepository, ProductCategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<ProductCategory> findAllCategories() {
        return categoryRepository.findAll();
    }

    public List<ProductCategoryDto> findAllCategoryNames() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ProductCategory> findAllById(List<Long> ids) {
        return categoryRepository.findAllById(ids);
    }
}