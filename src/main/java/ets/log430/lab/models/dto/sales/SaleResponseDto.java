package ets.log430.lab.models.dto.sales;

import java.time.LocalDateTime;
import java.util.List;

public class SaleResponseDto {
    private Long saleId;
    private LocalDateTime saleDate;
    private String customerName;
    private double totalAmount;
    private List<SaleProductDto> products;

    public SaleResponseDto(Long saleId, LocalDateTime saleDate, String customerName, double totalAmount, List<SaleProductDto> products) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.products = products;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<SaleProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<SaleProductDto> products) {
        this.products = products;
    }
}
