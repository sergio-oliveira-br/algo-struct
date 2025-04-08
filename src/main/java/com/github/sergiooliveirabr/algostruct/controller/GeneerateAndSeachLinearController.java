package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.generator.RandomNumService;
import com.github.sergiooliveirabr.algostruct.service.linearsearch.LinearSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/generate-and-search-linear")
public class GeneerateAndSeachLinearController {

    private final RandomNumService randomNumService;
    private final LinearSearchService linearSearchService;

    @Autowired
    public GeneerateAndSeachLinearController(RandomNumService randomNumService, LinearSearchService linearSearchService) {
        this.randomNumService = randomNumService;
        this.linearSearchService = linearSearchService;
    }

    @GetMapping("/page")
    public String showLinearSearchPage() {
        return "linear-search";
    }

    @GetMapping
    public String generateAndSearchLinear(Model model,
                                          @RequestParam int qty,
                                          @RequestParam int target) {

        int[] numbersGenerated = randomNumService.generateRandomNum(qty);
        String result = linearSearchService.linearSeach(numbersGenerated, target);

        model.addAttribute("numbersGenerated", Arrays.toString(numbersGenerated));
        model.addAttribute("qty", "It was generated " +  qty + " random numbers");
        model.addAttribute("target", "Target: " + target);
        model.addAttribute("result", result);

        return "linear-search";
    }
}
