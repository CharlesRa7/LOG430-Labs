package ets.log430.lab.services;

import ets.log430.lab.entities.ProductCategory;
import ets.log430.lab.repositories.ProductCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository categoryRepository;

    public ProductCategoryService(ProductCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<ProductCategory> findAllCategories() {
        return categoryRepository.findAll();
    }

    public List<ProductCategoryNameDto> findAllCategoryNames() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> new ProductCategoryNameDto(category.getName()))
                .collect(Collectors.toList());
    }
}