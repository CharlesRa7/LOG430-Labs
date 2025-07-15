package ets.log430.lab.models.dto.logistics;

import ets.log430.lab.models.dto.product.ProductBasicInfo;
import ets.log430.lab.models.dto.stores.StoreBasicInfo;

import java.util.List;

public class SupplyRequestFormDto {
    private List<StoreBasicInfo> stores;
    private Long logisticsCenterId;
    private ProductBasicInfo product;

    public SupplyRequestFormDto(List<StoreBasicInfo> stores, Long logisticsCenterId, ProductBasicInfo product) {
        this.stores = stores;
        this.logisticsCenterId = logisticsCenterId;
        this.product = product;
    }

    public List<StoreBasicInfo> getStores() {
        return stores;
    }

    public void setStores(List<StoreBasicInfo> stores) {
        this.stores = stores;
    }

    public Long getLogisticsCenterId() {
        return logisticsCenterId;
    }

    public void setLogisticsCenterId(Long logisticsCenterId) {
        this.logisticsCenterId = logisticsCenterId;
    }

    public ProductBasicInfo getProduct() {
        return product;
    }

    public void setProduct(ProductBasicInfo product) {
        this.product = product;
    }
}
