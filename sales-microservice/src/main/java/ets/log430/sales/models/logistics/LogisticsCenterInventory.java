package ets.log430.sales.models.logistics;

import ets.log430.sales.models.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "logistics_center_inventory")
public class LogisticsCenterInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "logistics_center_id", nullable = false)
    private LogisticsCenter logisticsCenter;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    public LogisticsCenterInventory() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LogisticsCenter getLogisticsCenter() { return logisticsCenter; }
    public void setLogisticsCenter(LogisticsCenter logisticsCenter) { this.logisticsCenter = logisticsCenter; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}