package ets.log430.lab.mappers;

import ets.log430.lab.models.dto.logistics.LogisticsCenterDto;
import ets.log430.lab.models.dto.logistics.LogisticsCenterInventoryDto;
import ets.log430.lab.models.logistics.LogisticsCenter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogisticsCenterMapper {

    public LogisticsCenterDto toDto(LogisticsCenter logisticsCenter,
                                    List<LogisticsCenterInventoryDto> inventoryDto) {
        return new LogisticsCenterDto(
                logisticsCenter.getName(),
                logisticsCenter.getId(),
                inventoryDto
        );
    }
}
