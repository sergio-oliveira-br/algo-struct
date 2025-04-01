package com.github.sergiooliveirabr.algostruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class RandomNumService {

    private final ElapsedTimeService elapsedTimeService;

    @Autowired
    public RandomNumService(ElapsedTimeService elapsedTimeService) {
        this.elapsedTimeService = elapsedTimeService;
    }

    public int[] generateRandomNum(int qty) {

        Random randomNums = new Random();
        int[] randomNumbersArray = new int[qty];

        for (int i = 0; i < qty; i++) {
            randomNumbersArray[i] = randomNums.nextInt(100);
        }

        System.out.println("This is the Random Number Array: " + Arrays.toString(randomNumbersArray));

        return randomNumbersArray;
    }
}
