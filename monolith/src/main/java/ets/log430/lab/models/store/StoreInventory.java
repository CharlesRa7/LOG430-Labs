package ets.log430.lab.models.store;

import ets.log430.lab.models.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "store_inventory")
public class StoreInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "min_threshold", nullable = false)
    private Integer minThreshold;

    @Column(name = "max_threshold")
    private Integer maxThreshold;

    public StoreInventory() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getMinThreshold() { return minThreshold; }
    public void setMinThreshold(Integer minThreshold) { this.minThreshold = minThreshold; }
    public Integer getMaxThreshold() { return maxThreshold; }
    public void setMaxThreshold(Integer maxThreshold) { this.maxThreshold = maxThreshold; }
}
