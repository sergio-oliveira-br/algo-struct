package com.github.sergiooliveirabr.algostruct.service.findelement;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FindMaxService implements FindMinMaxInterface {

    @Override
    public int findMinMax(int[] arrayNumbers) {

        System.out.println("\nExecuting the Find Max method");

        Arrays.sort(arrayNumbers);

        return arrayNumbers[arrayNumbers.length - 1];
    }
}
