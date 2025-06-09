package ets.log430.lab.models.dto;

public class SupplyRequestDto {
    Long logisticsCenterId;
    Long productId;
    Long storeId;
    Integer quantity;

    public SupplyRequestDto(Long logisticsCenterId, Long productId, Long storeId, Integer quantity) {
        this.logisticsCenterId = logisticsCenterId;
        this.productId = productId;
        this.storeId = storeId;
        this.quantity = quantity;
    }

    public Long getLogisticsCenterId() {
        return logisticsCenterId;
    }

    public void setLogisticsCenterId(Long logisticsCenterId) {
        this.logisticsCenterId = logisticsCenterId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
