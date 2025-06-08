package ets.log430.lab.models.dto;

public class LogisticsCenterInventoryDto {
    private Long productId;
    private String productName;
    private int quantity;

    public LogisticsCenterInventoryDto(Long productId, String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
