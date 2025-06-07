package ets.log430.lab.models.dto;

public class StoreInventoryDto {
    private String productName;
    private int quantity;
    private int minimumStockLevel;
    private int maximumStockLevel;

    public StoreInventoryDto(String productName, int quantity, int minimumStockLevel, int maximumStockLevel) {
        this.productName = productName;
        this.quantity = quantity;
        this.minimumStockLevel = minimumStockLevel;
        this.maximumStockLevel = maximumStockLevel;
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

    public int getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(int minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    public int getMaximumStockLevel() {
        return maximumStockLevel;
    }

    public void setMaximumStockLevel(int maximumStockLevel) {
        this.maximumStockLevel = maximumStockLevel;
    }
}
