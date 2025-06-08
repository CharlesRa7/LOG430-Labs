package ets.log430.lab.controllers.logistics;

import ets.log430.lab.models.dto.LogisticsCenterDto;
import ets.log430.lab.models.dto.LogisticsCenterInventoryDto;
import ets.log430.lab.services.logistics.LogisticsCenterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("logistics")
public class LogisticsCenterController {

    private final LogisticsCenterService logisticsCenterService;

    public LogisticsCenterController(LogisticsCenterService logisticsCenterService) {
        this.logisticsCenterService = logisticsCenterService;
    }

    @GetMapping("{id}/stock")
    public String getLogisticsCenterStock(@PathVariable Long id, Model model) {
        LogisticsCenterDto logisticsCenter = logisticsCenterService.consultCentralStock(id);
        model.addAttribute("logisticsCenter", logisticsCenter);
        return "logistics-center-stock";
    }

    @GetMapping("{id}/supply-request-form/{productId}")
    public String showSupplyRequestForm(@PathVariable Long id, @PathVariable Long productId, Model model) {
        LogisticsCenterDto logisticsCenter = logisticsCenterService.consultCentralStock(id);
        List<LogisticsCenterInventoryDto> inventory = logisticsCenter.getInventory();

        model.addAttribute("logisticsCenter", logisticsCenter);
        model.addAttribute("productId", productId);

        return "supply-request-form";
    }
}
