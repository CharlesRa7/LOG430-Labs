package ets.log430.lab.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany
    private List<SaleItem> returnedItems;

    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale originalSale;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User processedBy;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SaleItem> getReturnedItems() {
        return returnedItems;
    }

    public void setReturnedItems(List<SaleItem> returnedItems) {
        this.returnedItems = returnedItems;
    }

    public Sale getOriginalSale() {
        return originalSale;
    }

    public void setOriginalSale(Sale originalSale) {
        this.originalSale = originalSale;
    }

    public User getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(User processedBy) {
        this.processedBy = processedBy;
    }
}
