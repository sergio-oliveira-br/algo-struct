package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.linearsearch.duplicatecheck.DuplicateCheckService;
import com.github.sergiooliveirabr.algostruct.service.linearsearch.findelement.FindMinMaxService;
import com.github.sergiooliveirabr.algostruct.service.generator.RandomNumService;
import com.github.sergiooliveirabr.algostruct.service.linearsearch.LinearSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showLinearSearchPage(Model model) {

        //Generate And Search Linear
        if(model.containsAttribute("numbersGenerated")){
            String numbersGenerated  = (String) model.getAttribute("numbersGenerated");
            model.addAttribute("numbersGenerated", numbersGenerated);

            String qtyGenerated = (String) model.getAttribute("qty");
            model.addAttribute("qty", qtyGenerated);


            String target = (String) model.getAttribute("target");
            model.addAttribute("target", target);

            String result = (String) model.getAttribute("result");
            model.addAttribute("result", result);
        }

        //Find Min and Max
        if(model.containsAttribute("findNumbersGenerated")){
            String findNumbersGenerated  = (String) model.getAttribute("findNumbersGenerated");
            model.addAttribute("findNumbersGenerated", findNumbersGenerated);

            Map<String, Integer> resultMinMax = (Map<String, Integer>) model.getAttribute("resultMinMax");
            model.addAttribute("resultMinMax", resultMinMax);
        }

        if(model.containsAttribute("duplicatesNumbersGenerated")){
            String duplicatesNumbersGenerated  = (String) model.getAttribute("duplicatesNumbersGenerated");
            model.addAttribute("duplicatesNumbersGenerated",duplicatesNumbersGenerated);

            Map<String, Boolean> resultCheckDuplicates = (Map<String, Boolean>) model.getAttribute("resultCheckDuplicates");
            model.addAttribute("resultCheckDuplicates", resultCheckDuplicates);
        }

        return "linear-search";
    }

    @PostMapping("/linear-search")
    public String generateAndSearchLinear(RedirectAttributes redirectAttributes,
                                          @RequestParam int qty,
                                          @RequestParam int target) {

        int[] numbersGenerated = randomNumService.generateRandomNum(qty);
        String result = linearSearchService.linearSearch(numbersGenerated, target);

        redirectAttributes.addFlashAttribute("numbersGenerated", Arrays.toString(numbersGenerated));
        redirectAttributes.addFlashAttribute("qty", "It was generated " +  qty + " random numbers");
        redirectAttributes.addFlashAttribute("target", "Target: " + target);
        redirectAttributes.addFlashAttribute("result", result);

        return "redirect:/generate-and-search/page";
    }

    @PostMapping("/find-min-max")
    public String findMinMax(RedirectAttributes redirectAttributes,
                             @RequestParam int arraySize,
                             @RequestParam List<String> findMinMaxAlgorithm) {

        int[] numbersGenerated = randomNumService.generateRandomNum(arraySize);
        Map<String, Integer> resultMinMax = findMinMaxService.executeFindMinMaxAlgorithms(numbersGenerated, findMinMaxAlgorithm);

        redirectAttributes.addFlashAttribute("findNumbersGenerated", Arrays.toString(numbersGenerated));
        redirectAttributes.addFlashAttribute("resultMinMax", resultMinMax);

        return "redirect:/generate-and-search/page";
    }

    @PostMapping("/check-duplicates")
    public String checkDuplicates(RedirectAttributes redirectAttributes,
                                  @RequestParam int arrayLength,
                                  @RequestParam List<String> duplicateCheckerAlgoristhm) {

        int[] numbersGenerated = randomNumService.generateRandomNum(arrayLength);
        Map<String, Boolean> resultCheckDuplicates = duplicateCheckService
                .executeDuplicateCheckAlgorithms(numbersGenerated, duplicateCheckerAlgoristhm);

        redirectAttributes.addFlashAttribute("duplicatesNumbersGenerated", Arrays.toString(numbersGenerated));
        redirectAttributes.addFlashAttribute("resultCheckDuplicates", resultCheckDuplicates);

        return "redirect:/generate-and-search/page";
    }
}