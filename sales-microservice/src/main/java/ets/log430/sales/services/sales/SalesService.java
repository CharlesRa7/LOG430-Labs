package ets.log430.sales.services.sales;

import ets.log430.sales.models.dto.sales.SaleProductDto;
import ets.log430.sales.models.dto.sales.SaleResponseDto;
import ets.log430.sales.models.sales.Sale;
import ets.log430.sales.repositories.sales.SalesRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<SaleResponseDto> getSalesForPeriod(LocalDate startDate, LocalDate endDate) {

        // Convert LocalDate to LocalDateTime for the repository query
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate != null ? endDate.atTime(23, 59, 59) : LocalDateTime.now();

        List<Sale> sales = salesRepository.findAllForPeriod(startDateTime, endDateTime);

        return sales.stream()
                .map(sale -> new SaleResponseDto(
                        sale.getId(),
                        sale.getDate(),
                        sale.getProcessedBy().getName(),
                        sale.getTotalAmount().doubleValue(),
                        sale.getItems().stream()
                                .map(item -> new SaleProductDto(
                                        item.getProduct().getName(),
                                        item.getQuantity(),
                                        item.getSubTotal())).toList()))
                .toList();
    }
}
