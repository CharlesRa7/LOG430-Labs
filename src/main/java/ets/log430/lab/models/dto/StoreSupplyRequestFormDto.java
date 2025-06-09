package ets.log430.lab.models.dto;

public class StoreSupplyRequestFormDto {
    private Long storeId;
    private String storeName;

    public StoreSupplyRequestFormDto(Long storeId, String storeName) {
        this.storeId = storeId;
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
