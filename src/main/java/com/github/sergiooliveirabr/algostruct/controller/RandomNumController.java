package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.BubbleSortService;
import com.github.sergiooliveirabr.algostruct.service.RandomNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/random-num")
public class RandomNumController {

    private final RandomNumService randomNumService;

    @Autowired
    public RandomNumController(RandomNumService randomNumService) {
        this.randomNumService = randomNumService;
    }

    @GetMapping("/generate")
    public ResponseEntity<String> getRandomNum(int qty) {

        randomNumService.generateRandomNum(qty);
        return ResponseEntity.status(HttpStatus.CREATED).body(qty + " numbers genereted successfully");
    }
}
