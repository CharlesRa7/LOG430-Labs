package ets.log430.sales.services.logistics;

import ets.log430.sales.mappers.SupplyRequestMapper;
import ets.log430.sales.models.dto.logistics.SupplyRequestDto;
import ets.log430.sales.models.dto.logistics.SupplyRequestFormDto;
import ets.log430.sales.models.dto.logistics.SupplyRequestResponseDto;
import ets.log430.sales.models.dto.product.ProductBasicInfo;
import ets.log430.sales.models.dto.stores.StoreBasicInfo;
import ets.log430.sales.models.logistics.LogisticsCenter;
import ets.log430.sales.models.logistics.SupplyRequest;
import ets.log430.sales.models.logistics.SupplyRequestStatus;
import ets.log430.sales.models.product.Product;
import ets.log430.sales.models.store.Store;
import ets.log430.sales.repositories.logistics.SupplyRequestRepository;
import ets.log430.sales.services.product.ProductService;
import ets.log430.sales.services.store.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyRequestService {

    private final StoreService storeService;
    private final ProductService productService;
    private final SupplyRequestRepository supplyRequestRepository;
    private final SupplyRequestMapper supplyRequestMapper;
    private final LogisticsCenterService logisticsCenterService;

    public SupplyRequestService(StoreService storeService,
                                ProductService productService,
                                SupplyRequestRepository supplyRequestRepository,
                                SupplyRequestMapper supplyRequestMapper,
                                LogisticsCenterService logisticsCenterService) {
        this.storeService = storeService;
        this.productService = productService;
        this.supplyRequestRepository = supplyRequestRepository;
        this.supplyRequestMapper = supplyRequestMapper;
        this.logisticsCenterService = logisticsCenterService;
    }


    public SupplyRequestFormDto fetchSupplyRequestFormDetails(Long logisticsCenterId, Long productId) {
        List<StoreBasicInfo> stores = storeService.getAllStoresBasicInfo();
        System.out.println("Stores found: " + stores.size());
        if (stores.isEmpty()) {
            throw new RuntimeException("No stores found");
        }

        ProductBasicInfo product = productService.getBasicInfoById(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        return new SupplyRequestFormDto(stores, logisticsCenterId, product);
    }

    public SupplyRequestResponseDto createSupplyRequest(SupplyRequestDto supplyRequestDto) {
        Store store = storeService.getStoreById(supplyRequestDto.getStoreId());
        Product product = productService.getProductById(supplyRequestDto.getProductId());
        LogisticsCenter logisticsCenter = logisticsCenterService.getLogisticsCenterById(supplyRequestDto.getLogisticsCenterId());

        SupplyRequest supplyRequest = new SupplyRequest();

        supplyRequest.setStore(store);
        supplyRequest.setProduct(product);
        supplyRequest.setLogisticsCenter(logisticsCenter);
        supplyRequest.setQuantityRequested(supplyRequestDto.getQuantity());
        supplyRequest.setStatus(SupplyRequestStatus.PENDING);

        SupplyRequest savedRequest = supplyRequestRepository.save(supplyRequest);

        return supplyRequestMapper.toResponseDto(savedRequest);
    }
}
