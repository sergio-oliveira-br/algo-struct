package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.ElapsedTimeService;
import com.github.sergiooliveirabr.algostruct.service.RandomNumService;
import com.github.sergiooliveirabr.algostruct.service.SortingAlgorithm;
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
    private final ElapsedTimeService elapsedTimeService;
    private final Map<String, SortingAlgorithm> sortingAlgorithms;
    private final SortingAlgorithm sortingAlgorithm;

    public GenerateAndSortController(RandomNumService randomNumService, ElapsedTimeService elapsedTimeService,
                                     Map<String, SortingAlgorithm> sortingAlgorithms, SortingAlgorithm sortingAlgorithm) {
        this.randomNumService = randomNumService;
        this.elapsedTimeService = elapsedTimeService;
        this.sortingAlgorithms = sortingAlgorithms;
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @GetMapping
    public String GenerateAndSort(Model model,
                                  @RequestParam int qty,
                                  @RequestParam("algorithms") List<String> algorithms) {

        //Generate Random Nums
        int[] generatedNumbers = randomNumService.generateRandomNum(qty);
        model.addAttribute("randomNumbers", Arrays.toString(generatedNumbers));
        model.addAttribute("qty", "Amount of Data: " + qty);

        Map<String, Long> executionTimes = new HashMap<>();

        for(String algorithmName : algorithms) {

            if(sortingAlgorithm.getAlgorithmName() != null) {
                long elapsedTime = elapsedTimeService.formatElapsedTime(sortingAlgorithm.sort(generatedNumbers.clone()));
                executionTimes.put(algorithmName,elapsedTime);
                System.out.println("Elapsed time: " + elapsedTime);
            }
        }

        model.addAttribute("executionTimes", executionTimes);

        return "index";
    }
}
