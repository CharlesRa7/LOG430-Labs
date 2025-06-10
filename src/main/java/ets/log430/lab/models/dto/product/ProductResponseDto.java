package ets.log430.lab.models.dto.product;

import java.util.List;

public class ProductResponseDto {
    private Long id;
    private String name;
    private double price;
    private List<String> categories;

    public ProductResponseDto() {}
    public ProductResponseDto(Long id, String name, double price, List<String> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public List<String> getCategories() {
        return categories;
    }
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}