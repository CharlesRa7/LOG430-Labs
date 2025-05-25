package ets.log430.lab.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SaleProductId implements Serializable {
    private Long saleId;
    private Long productId;

    // Getters, setters, equals, and hashCode
    // ...

    public SaleProductId() {}

    public SaleProductId(Long saleId, Long productId) {
        this.saleId = saleId;
        this.productId = productId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleProductId)) return false;
        SaleProductId that = (SaleProductId) o;
        return Objects.equals(saleId, that.saleId) &&
               Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, productId);
    }
}