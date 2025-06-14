package ets.log430.lab.mappers;

import ets.log430.lab.models.dto.logistics.SupplyRequestResponseDto;
import ets.log430.lab.models.logistics.SupplyRequest;
import org.springframework.stereotype.Component;

@Component
public class SupplyRequestMapper {

    public SupplyRequestResponseDto toResponseDto(SupplyRequest supplyRequest) {
        if (supplyRequest == null) {
            return null;
        }

        return new SupplyRequestResponseDto(
                supplyRequest.getStore().getName(),
                supplyRequest.getProduct().getName(),
                supplyRequest.getQuantityRequested(),
                supplyRequest.getStatus().name(),
                supplyRequest.getLogisticsCenter().getName(),
                supplyRequest.getLogisticsCenter().getId()
        );
    }
}
