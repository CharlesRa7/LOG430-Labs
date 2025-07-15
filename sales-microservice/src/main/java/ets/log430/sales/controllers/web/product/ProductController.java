package ets.log430.sales.controllers.web.product;

import ets.log430.sales.models.dto.product.ProductAddRequestDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import ets.log430.sales.services.product.ProductService;

import java.util.List;

import ets.log430.sales.models.dto.product.ProductResponseDto;
import org.springframework.ui.Model;
import ets.log430.sales.services.product.ProductCategoryService;
import ets.log430.sales.models.dto.product.ProductCategoryDto;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService categoryService;

    public ProductController(ProductService productService, ProductCategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping({"", "/"})
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
        List<ProductCategoryDto> categories = categoryService.findAllCategoryNames();
        model.addAttribute("categories", categories);
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductAddRequestDto productAddRequestDto) {
        productService.save(productAddRequestDto);
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteById(id);
        return "redirect:/products";
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
