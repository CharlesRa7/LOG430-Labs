package ets.log430.sales.mappers;

import ets.log430.sales.models.dto.logistics.LogisticsCenterInventoryDto;
import ets.log430.sales.models.logistics.LogisticsCenterInventory;
import org.springframework.stereotype.Component;

@Component
public class LogisticsCenterInventoryMapper {
    public LogisticsCenterInventoryDto toDto(LogisticsCenterInventory logisticsCenterInventory) {
        return new LogisticsCenterInventoryDto(
                logisticsCenterInventory.getProduct().getId(),
                logisticsCenterInventory.getProduct().getName(),
                logisticsCenterInventory.getQuantity()
        );
    }
}
