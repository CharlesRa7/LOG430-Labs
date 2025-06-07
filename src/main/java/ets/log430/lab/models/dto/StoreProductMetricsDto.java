package ets.log430.lab.models.dto;

import java.math.BigDecimal;

public class StoreProductMetricsDto {
    private String productName;
    private int quantitySold;
    private BigDecimal revenueGenerated;

    public StoreProductMetricsDto(String productName, int quantitySold, BigDecimal revenueGenerated) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.revenueGenerated = revenueGenerated;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public BigDecimal getRevenueGenerated() {
        return revenueGenerated;
    }

    public void setRevenueGenerated(BigDecimal revenueGenerated) {
        this.revenueGenerated = revenueGenerated;
    }
}
