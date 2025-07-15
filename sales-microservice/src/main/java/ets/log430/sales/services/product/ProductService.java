package ets.log430.sales.services.product;

import ets.log430.sales.models.dto.product.ProductAddRequestDto;
import ets.log430.sales.models.dto.product.ProductBasicInfo;
import ets.log430.sales.models.dto.product.request.ProductUpdateRequestDto;
import ets.log430.sales.models.dto.product.response.ProductUpdateResponseDto;
import ets.log430.sales.models.product.Product;
import ets.log430.sales.models.product.ProductCategory;
import ets.log430.sales.repositories.product.ProductRepository;
import ets.log430.sales.models.dto.product.ProductResponseDto;
import ets.log430.sales.mappers.ProductMapper;
import jakarta.validation.Valid;
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

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    public ProductBasicInfo getBasicInfoById(Long id) {
        return productRepository.findIdAndNameById(id);
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

    public ProductUpdateResponseDto updateProduct(Long id, @Valid ProductUpdateRequestDto updateDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));

        ProductUpdateResponseDto responseDto = new ProductUpdateResponseDto();
        responseDto.setOldProduct(new ProductUpdateRequestDto(
                product.getName(),
                product.getPrice()
        ));

        product.setName(updateDto.getName());
        product.setPrice(updateDto.getPrice());

        Product updatedProduct = productRepository.save(product);

        responseDto.setNewProduct(new ProductUpdateRequestDto(
                updatedProduct.getName(),
                updatedProduct.getPrice()
        ));

        return responseDto;
    }
}