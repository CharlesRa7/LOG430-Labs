package ets.log430.lab.models.dto.stores;

import ets.log430.lab.models.dto.sales.SaleDto;

import java.math.BigDecimal;
import java.util.Set;

public class StoresReportDto {
    private String storeName;
    private Set<SaleDto> sales;
    private BigDecimal totalSales;
    private Set<StoreProductMetricsDto> productMetrics;
    private Set<StoreInventoryDto> inventory;

    public StoresReportDto(String storeName, Set<SaleDto> sales, BigDecimal totalSales, Set<StoreProductMetricsDto> productMetrics, Set<StoreInventoryDto> inventory) {
        this.storeName = storeName;
        this.sales = sales;
        this.totalSales = totalSales;
        this.productMetrics = productMetrics;
        this.inventory = inventory;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Set<SaleDto> getSales() {
        return sales;
    }

    public void setSales(Set<SaleDto> sales) {
        this.sales = sales;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public Set<StoreProductMetricsDto> getProductMetrics() {
        return productMetrics;
    }

    public void setProductMetrics(Set<StoreProductMetricsDto> productMetrics) {
        this.productMetrics = productMetrics;
    }

    public Set<StoreInventoryDto> getInventory() {
        return inventory;
    }

    public void setInventory(Set<StoreInventoryDto> inventory) {
        this.inventory = inventory;
    }
}
