package ets.log430.sales.controllers.api.v1.sales;

import ets.log430.sales.models.dto.sales.SaleResponseDto;
import ets.log430.sales.services.sales.SalesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesApiController {

    private final SalesService salesService;

    public SalesApiController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/period")
    @Operation(summary = "Get All Sales for a Given Period")
    @Parameter(name = "startDate", description = "Start Date", example = "2024-01-01")
    public ResponseEntity<List<SaleResponseDto>> getSalesForPeriod(
            @RequestParam LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        // Logic to fetch sales data for the given period

        List<SaleResponseDto> sales = salesService.getSalesForPeriod(startDate, endDate);

        return ResponseEntity.ok(sales);
    }
}
