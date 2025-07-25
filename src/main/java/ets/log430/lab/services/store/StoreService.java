package ets.log430.lab.services.store;

import ets.log430.lab.mappers.StoreMapper;
import ets.log430.lab.models.dto.stores.StoreBasicInfo;
import ets.log430.lab.models.dto.stores.StoreInventoryDto;
import ets.log430.lab.models.dto.stores.StoresReportDto;
import ets.log430.lab.models.store.Store;
import ets.log430.lab.models.store.StoreInventory;
import ets.log430.lab.repositories.store.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with ID: " + id));
    }

    public StoreBasicInfo getStoreBasicInfoById(Long id) {
        return storeRepository.findIdAndNameById(id);
    }

    public List<StoreBasicInfo> getAllStoresBasicInfo() {
        return storeRepository.findAllIdAndName();
    }

    public List<StoreInventoryDto> getStoreInventory(Long storeId) {
        Optional<Store> store = storeRepository.findById(storeId);

        if (store.isEmpty()) {
            throw new RuntimeException("Store not found with ID: " + storeId);
        }

        return store.get().getInventory().stream()
                .map(storeMapper::storeInventoryToStoreInventoryDto)
                .toList();
    }

}
