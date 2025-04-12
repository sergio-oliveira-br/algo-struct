package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.generator.RandomNumService;
import com.github.sergiooliveirabr.algostruct.service.sort.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/generate-and-sort")
public class GenerateAndSortController {

    private final RandomNumService randomNumService;
    private final SortingService sortingService;

    @Autowired
    public GenerateAndSortController(RandomNumService randomNumService,
                                     SortingService sortingService) {

        this.randomNumService = randomNumService;
        this.sortingService = sortingService;
    }

    @GetMapping
    public String GenerateAndSort(Model model,
                                  @RequestParam int qty,
                                  @RequestParam List<String> algorithm) {

        System.out.println("[Controller] - User Selected - Algorithm: " + algorithm);

        //Generate Random Nums
        int[] generatedNumbers = randomNumService.generateRandomNum(qty);
        model.addAttribute("randomNumbers", Arrays.toString(generatedNumbers));
        model.addAttribute("qty", "Amount of Data: " + qty);

        Map<String, Long> executionTimes = sortingService.executeSortingAlgorithms(generatedNumbers, algorithm);
        model.addAttribute("executionTimes", executionTimes);

        return "sorting";
    }
}
