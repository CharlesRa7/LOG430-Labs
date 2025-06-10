package ets.log430.lab.models.dto.logistics;

import java.util.List;

public class LogisticsCenterDto {
    private String logisticsCenterName;
    private Long logisticsCenterId;
    private List<LogisticsCenterInventoryDto> inventory;

    public LogisticsCenterDto(String logisticsCenterName, Long logisticsCenterId, List<LogisticsCenterInventoryDto> inventory) {
        this.logisticsCenterName = logisticsCenterName;
        this.logisticsCenterId = logisticsCenterId;
        this.inventory = inventory;
    }

    public String getLogisticsCenterName() {
        return logisticsCenterName;
    }

    public void setLogisticsCenterName(String logisticsCenterName) {
        this.logisticsCenterName = logisticsCenterName;
    }

    public Long getLogisticsCenterId() {
        return logisticsCenterId;
    }

    public void setLogisticsCenterId(Long logisticsCenterId) {
        this.logisticsCenterId = logisticsCenterId;
    }

    public List<LogisticsCenterInventoryDto> getInventory() {
        return inventory;
    }

    public void setInventory(List<LogisticsCenterInventoryDto> inventory) {
        this.inventory = inventory;
    }
}
