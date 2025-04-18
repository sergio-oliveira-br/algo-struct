package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.duplicatecheck.DuplicateCheckService;
import com.github.sergiooliveirabr.algostruct.service.findelement.FindMinMaxService;
import com.github.sergiooliveirabr.algostruct.service.generator.RandomNumService;
import com.github.sergiooliveirabr.algostruct.service.linearsearch.LinearSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/generate-and-search")
public class GenerateAndSeachLinearController {

    private final RandomNumService randomNumService;
    private final LinearSearchService linearSearchService;
    private final FindMinMaxService findMinMaxService;
    private final DuplicateCheckService duplicateCheckService;


    @Autowired
    public GenerateAndSeachLinearController(RandomNumService randomNumService,
                                            LinearSearchService linearSearchService,
                                            FindMinMaxService findMinMaxService,
                                            DuplicateCheckService duplicateCheckService) {

        this.randomNumService = randomNumService;
        this.linearSearchService = linearSearchService;
        this.findMinMaxService = findMinMaxService;
        this.duplicateCheckService = duplicateCheckService;
    }

    @GetMapping("/page")
    public String showLinearSearchPage() {
        return "linear-search";
    }

    @GetMapping("/linear-search")
    public String generateAndSearchLinear(Model model,
                                          @RequestParam int qty,
                                          @RequestParam int target) {

        int[] numbersGenerated = randomNumService.generateRandomNum(qty);
        String result = linearSearchService.linearSearch(numbersGenerated, target);

        model.addAttribute("numbersGenerated", Arrays.toString(numbersGenerated));
        model.addAttribute("qty", "It was generated " +  qty + " random numbers");
        model.addAttribute("target", "Target: " + target);
        model.addAttribute("result", result);

        return "linear-search";
    }

    @GetMapping("/find-min-max")
    public String findMinMax(Model model,
                             @RequestParam int arraySize,
                             @RequestParam List<String> findMinMaxAlgorithm) {

        int[] numbersGenerated = randomNumService.generateRandomNum(arraySize);
        Map<String, Integer> resultMinMax = findMinMaxService.executeFindMinMaxAlgorithms(numbersGenerated, findMinMaxAlgorithm);

        model.addAttribute("findNumbersGenerated", Arrays.toString(numbersGenerated));
        model.addAttribute("resultMinMax", resultMinMax);

        return "linear-search";
    }

    @GetMapping("/check-duplicates")
    public String checkDuplicates(Model model,
                                  @RequestParam int arrayLenght,
                                  @RequestParam List<String> duplicateCheckerAlgoristhm) {

        System.out.println("Controlador Acessado");

        int[] numbersGenerated = randomNumService.generateRandomNum(arrayLenght);
        Map<String, Boolean> resultCheckDuplicates = duplicateCheckService.executeDuplicateCheckAlgorithms(numbersGenerated, duplicateCheckerAlgoristhm);

        model.addAttribute("duplicatesNumbersGenerated", Arrays.toString(numbersGenerated));
        model.addAttribute("resultCheckDuplicates", resultCheckDuplicates);

        return "linear-search";

    }
}
