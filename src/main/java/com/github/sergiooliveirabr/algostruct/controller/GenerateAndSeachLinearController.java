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
