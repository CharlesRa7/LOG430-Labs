package ets.log430.sales.models.dto.product.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProductUpdateRequestDto {
    @Schema(description = "The name of the product", example = "Novel")
    private String name;
    @Schema(description = "The price of the product", example = "15.50")
    private double price;

    public ProductUpdateRequestDto() {}

    public ProductUpdateRequestDto(String name, double price) {
        this.name = name;
        this.price = price;
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
}
