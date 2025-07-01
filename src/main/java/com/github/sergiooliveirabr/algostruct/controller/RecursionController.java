package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.dto.FactorialResult;
import com.github.sergiooliveirabr.algostruct.dto.FibonacciResult;
import com.github.sergiooliveirabr.algostruct.service.recursion.FactorialService;
import com.github.sergiooliveirabr.algostruct.service.recursion.FibonacciService;
import com.github.sergiooliveirabr.algostruct.service.recursion.ReverseStringService;
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
    private final FibonacciService fibonacciService;
    private final ReverseStringService reverseStringService;

    @Autowired
    public RecursionController(FactorialService factorialService,
                               FibonacciService fibonacciService,
                               ReverseStringService reverseStringService) {

        this.factorialService = factorialService;
        this.fibonacciService = fibonacciService;
        this.reverseStringService = reverseStringService;
    }

    @GetMapping("/page")
    public String showRecursionPage(Model model) {

        //Factorial
        model.addAttribute("factorialnum");
        model.addAttribute("factorial");
        model.addAttribute("steps");

        //Fibonacci
        model.addAttribute("fibonacciResult");

        //Reveser Word
        model.addAttribute("word");
        model.addAttribute("wordReversed");
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

    @PostMapping("/fibonacci")
    public String fibonacci(@RequestParam(name = "number", required = false ) int number,
                            RedirectAttributes redirectAttributes) {

        FibonacciResult fibResult = fibonacciService.displayFibonacciWithSteps(number);
        redirectAttributes.addFlashAttribute("fibonacciResult", fibResult);

        return "redirect:/recursion/page";
    }

    @PostMapping("/reverse")
    public String reverseStr(@RequestParam String word, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("word", word);
        redirectAttributes.addFlashAttribute("wordReversed", reverseStringService.reverseString(word));
        return "redirect:/recursion/page";
    }
}
