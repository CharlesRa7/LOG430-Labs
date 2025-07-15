package ets.log430.lab.models.logistics;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "logistics_centers")
public class LogisticsCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "logisticsCenter", cascade = CascadeType.ALL)
    private Set<LogisticsCenterInventory> inventory = new HashSet<>();

    @OneToMany(mappedBy = "logisticsCenter", cascade = CascadeType.ALL)
    private Set<SupplyRequest> supplyRequests = new HashSet<>();

    public LogisticsCenter() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<LogisticsCenterInventory> getInventory() { return inventory; }
    public void setInventory(Set<LogisticsCenterInventory> inventory) { this.inventory = inventory; }
    public Set<SupplyRequest> getSupplyRequests() { return supplyRequests; }
    public void setSupplyRequests(Set<SupplyRequest> supplyRequests) { this.supplyRequests = supplyRequests;}
}
