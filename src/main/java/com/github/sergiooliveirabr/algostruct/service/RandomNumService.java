package com.github.sergiooliveirabr.algostruct.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class RandomNumService {

    public int[] generateRandomNum(int qty) {

        Random randomNums = new Random();
        int[] randomNumbersArray = new int[qty];

        for (int i = 0; i < qty; i++) {
            randomNumbersArray[i] = randomNums.nextInt(100);
        }

        System.out.println("\nNumbers Generated: " + Arrays.toString(randomNumbersArray));

        return randomNumbersArray;
    }
}
