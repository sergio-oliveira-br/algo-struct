package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.BubbleSortService;
import com.github.sergiooliveirabr.algostruct.service.RandomNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/random-num")
public class RandomNumController {

    private final RandomNumService randomNumService;
    private final BubbleSortService bubbleSortService;

    @Autowired
    public RandomNumController(RandomNumService randomNumService,
                               BubbleSortService bubbleSortService) {
        this.randomNumService = randomNumService;
        this.bubbleSortService = bubbleSortService;
    }

    @GetMapping("/generate")
    public ResponseEntity<String> getRandomNum(int qty) {

        System.out.println("Starting the generation of " + qty + " random numbers");
        int [] myData = randomNumService.generateRandomNum(qty);

        System.out.println("Sorting");
        bubbleSortService.bubbleSort(myData);

        for (int i = 0; i < qty; i++) {
            System.out.println(myData[i]);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(qty + " numbers genereted successfully");
    }
}
