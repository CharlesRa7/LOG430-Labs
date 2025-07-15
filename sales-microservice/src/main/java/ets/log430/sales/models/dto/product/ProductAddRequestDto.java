package ets.log430.sales.models.dto.product;

import java.util.List;

public class ProductAddRequestDto {
    private String name;
    private double price;
    private int stockQuantity;
    private List<Long> categoryIds;

    public ProductAddRequestDto() {}

    public ProductAddRequestDto(String name, double price, int stockQuantity, List<Long> categoryIds) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.categoryIds = categoryIds;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
