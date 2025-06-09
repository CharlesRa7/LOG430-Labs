package ets.log430.lab.models.dto;

public class SupplyRequestResponseDto {
    private String storeName;
    private String productName;
    private int quantity;
    private String status;
    private String logisticsCenterName;
    private Long logisticsCenterId;

    public SupplyRequestResponseDto(String storeName, String productName, int quantity, String status, String logisticsCenterName, Long logisticsCenterId) {
        this.storeName = storeName;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
        this.logisticsCenterName = logisticsCenterName;
        this.logisticsCenterId = logisticsCenterId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogisticsCenterName() {
        return logisticsCenterName;
    }

    public void setLogisticsCenterName(String logisticsCenterName) {
        this.logisticsCenterName = logisticsCenterName;
    }

    public Long getLogisticsCenterId() {
        return logisticsCenterId;
    }

    public void setLogisticsCenterId(Long logisticsCenterId) {
        this.logisticsCenterId = logisticsCenterId;
    }
}
