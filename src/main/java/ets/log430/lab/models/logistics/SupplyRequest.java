package ets.log430.lab.models.logistics;

import ets.log430.lab.models.product.Product;
import ets.log430.lab.models.store.Store;
import jakarta.persistence.*;

@Entity
@Table(name = "supply_requests")
public class SupplyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "logistics_center_id", nullable = false)
    private LogisticsCenter logisticsCenter;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity_requested", nullable = false)
    private Integer quantityRequested;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SupplyRequestStatus status;

    public SupplyRequest() {}

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LogisticsCenter getLogisticsCenter() {
        return logisticsCenter;
    }

    public void setLogisticsCenter(LogisticsCenter logisticsCenter) {
        this.logisticsCenter = logisticsCenter;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(Integer quantityRequested) {
        this.quantityRequested = quantityRequested;
    }

    public SupplyRequestStatus getStatus() {
        return status;
    }

    public void setStatus(SupplyRequestStatus status) {
        this.status = status;
    }
}

enum SupplyRequestStatus {
    PENDING,
    APPROVED,
    DELIVERED,
    REJECTED,
    CANCELLED
}