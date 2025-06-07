package ets.log430.lab.mappers;

import ets.log430.lab.models.dto.*;
import ets.log430.lab.models.store.Store;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StoreMapper {
    public StoresReportDto storeToStoreReportDto(Store store) {

        Set<SaleProductDto> saleProducts = store.getSales().stream()
                .flatMap(sale -> sale.getItems().stream()
                        .map(product -> new SaleProductDto(
                                product.getProduct().getName(),
                                product.getQuantity(),
                                product.getSubTotal()
                        )))
                .collect(Collectors.toSet());

        Set<SaleDto> sales = store.getSales().stream()
                .map(sale -> new SaleDto(
                        sale.getId(),
                        sale.getDate(),
                        saleProducts,
                        sale.getTotalAmount(),
                        sale.getProcessedBy().getName()
                ))
                .collect(Collectors.toSet());

        Set<StoreProductMetricsDto> productMetrics = store.getProductMetrics().stream()
                .map(productMetric -> new StoreProductMetricsDto(
                        productMetric.getProduct().getName(),
                        productMetric.getQuantitySold(),
                        productMetric.getRevenue()
                ))
                .collect(Collectors.toSet());

        Set<StoreInventoryDto> inventory = store.getInventory().stream()
                .map(inventoryItem -> new StoreInventoryDto(
                        inventoryItem.getProduct().getName(),
                        inventoryItem.getQuantity(),
                        inventoryItem.getMinThreshold(),
                        inventoryItem.getMaxThreshold()
                ))
                .collect(Collectors.toSet());

        return new StoresReportDto(
                store.getName(),
                sales,
                store.getSalesMetrics().getTotalSales(),
                productMetrics,
                inventory
        );
    }
}
