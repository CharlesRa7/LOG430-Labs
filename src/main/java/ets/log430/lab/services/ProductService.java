package ets.log430.lab.services;

import ets.log430.lab.entities.Product;
import ets.log430.lab.repositories.ProductRepository;
import ets.log430.lab.dto.ProductResponseDto;
import ets.log430.lab.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ProductResponseDto> search(String name, String category) {
        List<Product> products;
        if (name != null && category != null) {
            products = productRepository.findByNameContainingIgnoreCaseAndCategoryIgnoreCase(name, category);
        } else if (name != null) {
            products = productRepository.findByNameContainingIgnoreCase(name);
        } else if (category != null) {
            products = productRepository.findByCategoryIgnoreCase(category);
        } else {
            products = List.of();
        }
        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}