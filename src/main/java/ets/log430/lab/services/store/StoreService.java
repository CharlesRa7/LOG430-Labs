package ets.log430.lab.services.store;

import ets.log430.lab.mappers.StoreMapper;
import ets.log430.lab.models.dto.SaleDto;
import ets.log430.lab.models.dto.StoresReportDto;
import ets.log430.lab.models.store.Store;
import ets.log430.lab.repositories.product.ProductRepository;
import ets.log430.lab.repositories.store.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    public StoreService(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    public List<StoresReportDto> generateReport() {
        List<Store> stores = storeRepository.findAll();

        return stores.stream()
                .map(storeMapper::storeToStoreReportDto)
                .toList();
    }


}
