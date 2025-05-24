package ets.log430.lab.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import ets.log430.lab.services.ProductService;
import ets.log430.lab.entities.Product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import ets.log430.lab.dto.ProductResponseDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import ets.log430.lab.services.ProductCategoryService;
import ets.log430.lab.dto.ProductCategoryNameDto;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService categoryService;

    public ProductController(ProductService productService, ProductCategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<ProductResponseDto> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        ProductResponseDto product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/add-form")
    public String showAddProductForm(Model model) {
        List<ProductCategoryNameDto> categories = categoryService.findAllCategoryNames();
        model.addAttribute("categories", categories);
        return "add-product";
    }

    @GetMapping("/search")
    public String search(
        @RequestParam(required = false) String name, 
        @RequestParam(required = false) String category,
        Model model
    ) {
        List<ProductResponseDto> products = productService.search(name, category);
        model.addAttribute("products", products);
        return "products";
    }
}
