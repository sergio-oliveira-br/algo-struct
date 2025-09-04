package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.calculator.CalculatorOrchestrator;
import com.github.sergiooliveirabr.algostruct.service.calculator.CurrencyConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorOrchestrator calculatorOrchestrator;
    private final CurrencyConversionService currencyConversionService;

    public CalculatorController(CalculatorOrchestrator calculatorOrchestrator,
                                CurrencyConversionService currencyConversionService) {

        this.calculatorOrchestrator = calculatorOrchestrator;
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("/page")
    public String showCalculatorPage(Model model) {

        model.containsAttribute("productFinalCost");
        model.addAttribute("currency", currencyConversionService.getExchangeRate("CNY"));


        return "calculator";
    }

    @PostMapping("/orchestrator")
    public String showOrchestratorPage(RedirectAttributes redirectAttributes,
                                       @RequestParam int domesticShippingfixedFee,
                                       @RequestParam double productWeight) {

        double priceResult = calculatorOrchestrator.calculator(domesticShippingfixedFee, productWeight);
        redirectAttributes.addFlashAttribute("productFinalCost",
                "Final Price: " + priceResult);

        return "redirect:/calculator/page";
    }
}
