package com.github.sergiooliveirabr.algostruct.service.linearsearch.findelement;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FindMinService implements FindMinMaxInterface {

    @Override
    public int findMinMax(int[] arrayNumbers) {
        System.out.println("\nExecuting the Find Min method");

        Arrays.sort(arrayNumbers);

        return arrayNumbers[0];
    }
}
