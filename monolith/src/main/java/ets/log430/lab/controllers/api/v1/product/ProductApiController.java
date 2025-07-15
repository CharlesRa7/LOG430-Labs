package ets.log430.lab.controllers.api.v1.product;

import ets.log430.lab.models.dto.product.request.ProductUpdateRequestDto;
import ets.log430.lab.models.dto.product.response.ProductUpdateResponseDto;
import ets.log430.lab.services.product.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/monolith/products")
public class ProductApiController {

    private final ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product")
    @Parameter(name = "id", description = "Product ID", example = "3")
    public ResponseEntity<ProductUpdateResponseDto> updateProduct(
            @PathVariable Long id,
            @RequestBody @Valid ProductUpdateRequestDto updateDto) {
        ProductUpdateResponseDto updated = productService.updateProduct(id, updateDto);
        return ResponseEntity.ok(updated);
    }
}
