package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.dto.FinalCostDTO;
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
        model.addAttribute("productWeight");
        model.addAttribute("internalFee");
        model.addAttribute("externalFee");
        model.addAttribute("serviceCharge");
        model.addAttribute("plataformServiceFee");
        model.addAttribute("productFinalPriceCYR");
        model.addAttribute("productFinalPriceEUR");
        model.addAttribute("productPrice");


        model.addAttribute("currency", currencyConversionService.getExchangeRate("CNY"));

        return "calculator";
    }

    @PostMapping("/orchestrator")
    public String showOrchestratorPage(RedirectAttributes redirectAttributes,
                                       @RequestParam int domesticShippingfixedFee,
                                       @RequestParam double productWeight,
                                       @RequestParam double productPrice) {

        FinalCostDTO priceResult = calculatorOrchestrator.calculator(domesticShippingfixedFee, productWeight, productPrice);

        // Internal Shippment
        redirectAttributes.addFlashAttribute("internalFee",
                "Fee: " + priceResult.getInternalShipping() + " ¥");

        // External Shippment
        redirectAttributes.addFlashAttribute("externalFee",
                "Fee: " + priceResult.getExternalShipping() + " ¥");

        redirectAttributes.addFlashAttribute("productWeight",
                "Weight: " + productWeight + " grams");

        // Card Fee
        redirectAttributes.addFlashAttribute("productPrice",
                "Product Price w/tax: " + productPrice);

        redirectAttributes.addFlashAttribute("serviceCharge",
                "Service Charge: " + priceResult.getServiceCharge() + " ¥");

        redirectAttributes.addFlashAttribute("plataformServiceFee",
                "Plataform Service Fee: " + priceResult.getPlataformServiceFee() + " ¥");

        // Final Price CYR & EUR
        redirectAttributes.addFlashAttribute("productFinalPriceCYR",
                "Final Price: " + priceResult.getProductFinalPriceCYR() + " ¥");

        redirectAttributes.addFlashAttribute("productFinalPriceEUR",
                "Final Price: " + priceResult.getProductFinalPriceEUR() + " €");

        // The object
        redirectAttributes.addFlashAttribute("productFinalCost",
                "Final Price: " + priceResult);

        return "redirect:/calculator/page";
    }
}
