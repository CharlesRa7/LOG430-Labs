package ets.log430.lab.services;

import ets.log430.lab.dto.ProductAddRequestDto;
import ets.log430.lab.entities.Product;
import ets.log430.lab.entities.ProductCategory;
import ets.log430.lab.mappers.ProductCategoryMapper;
import ets.log430.lab.repositories.ProductRepository;
import ets.log430.lab.dto.ProductResponseDto;
import ets.log430.lab.mappers.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryService categoryService;

    public ProductService(
            ProductRepository productRepository,
            ProductMapper productMapper,
            ProductCategoryService categoryService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }

    public List<ProductResponseDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::productToResponseDto)
                .collect(Collectors.toList());
    }

    public List<ProductResponseDto> search(String name, String category) {
        boolean hasName = name != null && !name.isBlank();
        boolean hasCategory = category != null && !category.isBlank();

        List<Product> products;
        if (hasName && hasCategory) {
            products = productRepository.findByNameContainingIgnoreCaseAndCategoryIgnoreCase(name, category);
        } else if (hasName) {
            products = productRepository.findByNameContainingIgnoreCase(name);
        } else if (hasCategory) {
            products = productRepository.findByCategoryIgnoreCase(category);
        } else {
            products = productRepository.findAll();
        }
        return products.stream()
                .map(productMapper::productToResponseDto)
                .collect(Collectors.toList());
    }

    public ProductResponseDto findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productMapper.productToResponseDto(productOptional.get());
        } else {
            return null;
        }
    }

    public Product save(ProductAddRequestDto productAddRequestDto) {
        Product product = productMapper.productAddRequestDtoToEntity(productAddRequestDto);
        List<ProductCategory> categories = categoryService.findAllById(productAddRequestDto.getCategoryIds());
        product.setCategories(categories);
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}