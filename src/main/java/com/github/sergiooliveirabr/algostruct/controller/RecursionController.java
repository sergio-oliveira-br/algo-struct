package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.dto.FactorialResult;
import com.github.sergiooliveirabr.algostruct.service.recursion.FactorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/recursion")
public class RecursionController {

    private final FactorialService factorialService;

    @Autowired
    public RecursionController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @GetMapping("/page")
    public String showRecursionPage(Model model) {
        model.addAttribute("factorialnum");
        model.addAttribute("factorial");
        model.addAttribute("steps");
        return "recursion";
    }

    @PostMapping("/factorial")
    public String factorial(@RequestParam int number, RedirectAttributes redirectAttributes) {

        FactorialResult result = factorialService.calculateFactorialWithSteps(number);

        redirectAttributes.addFlashAttribute("factorialnum", result.getNumber());
        redirectAttributes.addFlashAttribute("factorial", result.getResult());
        redirectAttributes.addFlashAttribute("steps", result.getSteps());

        return "redirect:/recursion/page";
    }
}
