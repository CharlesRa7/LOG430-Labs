package ets.log430.lab.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import ets.log430.lab.services.ProductService;
import ets.log430.lab.entities.Product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import ets.log430.lab.dto.ProductResponseDto;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/search")
    public List<ProductResponseDto> search(
        @RequestParam(required = false) String name, 
        @RequestParam(required = false) String category
    ) {
        return productService.search(name, category);
    }
}
