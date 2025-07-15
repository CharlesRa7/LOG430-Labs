package ets.log430.sales.controllers.web.logistics;

import ets.log430.sales.models.dto.logistics.LogisticsCenterDto;
import ets.log430.sales.models.dto.logistics.SupplyRequestDto;
import ets.log430.sales.models.dto.logistics.SupplyRequestFormDto;
import ets.log430.sales.models.dto.logistics.SupplyRequestResponseDto;
import ets.log430.sales.services.logistics.LogisticsCenterService;
import ets.log430.sales.services.logistics.SupplyRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("logistics")
public class LogisticsCenterController {

    private final LogisticsCenterService logisticsCenterService;
    private final SupplyRequestService supplyRequestService;

    public LogisticsCenterController(LogisticsCenterService logisticsCenterService,
                                     SupplyRequestService supplyRequestService) {
        this.logisticsCenterService = logisticsCenterService;
        this.supplyRequestService = supplyRequestService;
    }

    @GetMapping("{id}/stock")
    public String getLogisticsCenterStock(@PathVariable Long id, Model model) {
        LogisticsCenterDto logisticsCenter = logisticsCenterService.consultCentralStock(id);
        model.addAttribute("logisticsCenter", logisticsCenter);
        return "logistics-center-stock";
    }

    @GetMapping("{id}/supply-request-form/{productId}")
    public String showSupplyRequestForm(@PathVariable Long id, @PathVariable Long productId, Model model) {
        SupplyRequestFormDto supplyRequestForm = supplyRequestService.fetchSupplyRequestFormDetails(id, productId);

        model.addAttribute("form", supplyRequestForm);

        return "supply-request-form";
    }

    @PostMapping("/supply-request")
    public String submitSupplyRequest(@ModelAttribute SupplyRequestDto supplyRequestDto, Model model) {
        SupplyRequestResponseDto responseDto = supplyRequestService.createSupplyRequest(supplyRequestDto);
        model.addAttribute("request", responseDto);
        return "supply-request-success";
    }
}
