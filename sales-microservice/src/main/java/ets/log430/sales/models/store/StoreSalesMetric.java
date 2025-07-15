package ets.log430.sales.models.store;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "store_sales_metrics")
public class StoreSalesMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "store_id", nullable = false, unique = true)
    private Store store;

    @Column(name = "weekly_sales", precision = 15, scale = 2)
    private BigDecimal weeklySales = BigDecimal.ZERO;

    @Column(name = "total_sales", precision = 15, scale = 2)
    private BigDecimal totalSales = BigDecimal.ZERO;

    public StoreSalesMetric() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }

    public BigDecimal getWeeklySales() { return weeklySales; }
    public void setWeeklySales(BigDecimal weeklySales) { this.weeklySales = weeklySales; }

    public BigDecimal getTotalSales() { return totalSales; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
}