package ets.log430.lab.services.logistics;

import ets.log430.lab.mappers.LogisticsCenterInventoryMapper;
import ets.log430.lab.mappers.LogisticsCenterMapper;
import ets.log430.lab.models.dto.LogisticsCenterDto;
import ets.log430.lab.models.dto.LogisticsCenterInventoryDto;
import ets.log430.lab.models.logistics.LogisticsCenter;
import ets.log430.lab.repositories.logistics.LogisticsCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogisticsCenterService {
    private final LogisticsCenterRepository logisticsCenterRepository;
    private final LogisticsCenterInventoryMapper logisticsCenterInventoryMapper;
    private final LogisticsCenterMapper logisticsCenterMapper;

    public LogisticsCenterService(LogisticsCenterRepository logisticsCenterRepository,
                                  LogisticsCenterInventoryMapper logisticsCenterInventoryMapper,
                                  LogisticsCenterMapper logisticsCenterMapper) {
        this.logisticsCenterRepository = logisticsCenterRepository;
        this.logisticsCenterInventoryMapper = logisticsCenterInventoryMapper;
        this.logisticsCenterMapper = logisticsCenterMapper;
    }

    public LogisticsCenterDto consultCentralStock(Long id) {
        Optional<LogisticsCenter> logisticsCenter = logisticsCenterRepository.findById(id);
        if (logisticsCenter.isEmpty()) {
            throw new RuntimeException("Logistics center not found");
        }

        List<LogisticsCenterInventoryDto> inventory = logisticsCenter.get().getInventory()
                .stream()
                .map(logisticsCenterInventoryMapper::toDto)
                .toList();

        return logisticsCenterMapper.toDto(logisticsCenter.get(), inventory);
    }

    public LogisticsCenter getLogisticsCenterById(Long id) {
        return logisticsCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Logistics center not found with ID: " + id));
    }
}
