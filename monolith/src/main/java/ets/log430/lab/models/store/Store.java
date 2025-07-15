package ets.log430.lab.models.store;

import ets.log430.lab.models.logistics.SupplyRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import ets.log430.lab.models.sales.Sale;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "store")
    private Set<Sale> sales = new HashSet<>();

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private StoreSalesMetric salesMetrics;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Set<StoreInventory> inventory = new HashSet<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Set<StoreProductMetrics> productMetrics = new HashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<SupplyRequest> supplyRequests = new HashSet<>();


    public Store() {}

    public Store(String name) {
        this.name = name;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Sale> getSales() { return sales; }
    public void setSales(Set<Sale> sales) { this.sales = sales; }
    public StoreSalesMetric getSalesMetrics() { return salesMetrics; }
    public void setSalesMetrics(StoreSalesMetric salesMetrics) { this.salesMetrics = salesMetrics; }
    public Set<StoreInventory> getInventory() { return inventory; }
    public void setInventory(Set<StoreInventory> inventory) { this.inventory = inventory; }
    public Set<StoreProductMetrics> getProductMetrics() { return productMetrics; }
    public void setProductMetrics(Set<StoreProductMetrics> productMetrics) { this.productMetrics = productMetrics; }
    public Set<SupplyRequest> getSupplyRequests() { return supplyRequests; }
    public void setSupplyRequests(Set<SupplyRequest> supplyRequests) { this.supplyRequests = supplyRequests;}
}
