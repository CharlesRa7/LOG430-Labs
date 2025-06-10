package ets.log430.lab.controllers.web.store;

import ets.log430.lab.models.dto.stores.StoresReportDto;
import ets.log430.lab.services.store.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/report")
    public String getStoresReport(Model model) {
        // Logic to generate store report
        List<StoresReportDto> storesReport = storeService.generateReport();
        model.addAttribute("storesReport", storesReport);
        return "stores-report"; // This should return the name of the view to render
    }
}
