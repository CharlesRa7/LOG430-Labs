package ets.log430.lab.controllers.api.v1.store;

import ets.log430.lab.models.dto.stores.StoreInventoryDto;
import ets.log430.lab.services.store.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreApiController {

    private final StoreService storeService;

    public StoreApiController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/{id}/stock")
    @Operation(summary = "Get store inventory")
    @Parameter(name = "id", description = "Store ID", example = "1")
    public ResponseEntity<List<StoreInventoryDto>> getStoreInventory(@PathVariable Long id) {
        List<StoreInventoryDto> storeInventory = storeService.getStoreInventory(id);

        return ResponseEntity.ok(storeInventory);
    }
}
