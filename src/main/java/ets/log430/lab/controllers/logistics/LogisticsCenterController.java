package ets.log430.lab.controllers.logistics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("logistics")
public class LogisticsCenterController {

    @GetMapping("{id}/stock")
    public String getLogisticsCenterStock(@PathVariable Long id, Model model) {

        return "logistics-center-stock"; // This should return the name of the view to render
    }
}
