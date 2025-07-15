package ets.log430.lab.models.dto.sales;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class SaleDto {
    private Long saleId;
    private LocalDateTime saleDate;
    private Set<SaleProductDto> products;
    private BigDecimal totalAmount;
    private String buyerName;

    public SaleDto(Long saleId, LocalDateTime saleDate, Set<SaleProductDto> products, BigDecimal totalAmount, String buyerName) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.products = products;
        this.totalAmount = totalAmount;
        this.buyerName = buyerName;
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

    public Set<SaleProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<SaleProductDto> products) {
        this.products = products;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
