package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.generator.RandomNumService;
import com.github.sergiooliveirabr.algostruct.service.sort.SortingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/page")
    public String showSortingPage(Model model,
                                  HttpSession session) {

        if(model.containsAttribute("errorMessage")){
            model.addAttribute("errorMessage", model.getAttribute("errorMessage"));
        }

        int[] generatedNumbers = (int[]) session.getAttribute("generatedNumbers");
        Map<String, Long> executionTimes = (Map<String, Long>) session.getAttribute("executionTimes");

        if(generatedNumbers != null){
            model.addAttribute("generatedNumbers", generatedNumbers);
            session.removeAttribute("generatedNumbers");
            model.addAttribute("qty", "Amount of Data: " + generatedNumbers.length);
        }

        if(executionTimes != null){
           model.addAttribute("executionTimes", executionTimes);
            session.removeAttribute("executionTimes");
        }
        return "sorting";
    }

    @PostMapping("/generator-sorter")
    public String GeneratorAndSort(RedirectAttributes redirectAttributes,
                                   @RequestParam int qty,
                                   @RequestParam (required = false) List<String> algorithm,
                                   HttpSession httpSession) {

        if (algorithm == null || algorithm.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Pick one algorithm to sort your data");

            return "redirect:/generate-and-sort/page";
        }
        
        int[] generatedNumbers = randomNumService.generateRandomNum(qty);
        Map<String, Long> executionTimes = sortingService.executeSortingAlgorithms(generatedNumbers, algorithm);

        httpSession.setAttribute("generatedNumbers", generatedNumbers);
        httpSession.setAttribute("executionTimes", executionTimes);

        return "redirect:/generate-and-sort/page";
    }
}
