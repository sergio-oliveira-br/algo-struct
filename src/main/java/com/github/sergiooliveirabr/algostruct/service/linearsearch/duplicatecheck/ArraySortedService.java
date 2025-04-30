package com.github.sergiooliveirabr.algostruct.service.linearsearch.duplicatecheck;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArraySortedService implements DuplicateCheckInterface {

    @Override
    public boolean isDuplicate(int[] arrayNumbers) {

        Arrays.sort(arrayNumbers);

        for(int i = 0; i < arrayNumbers.length - 1; i++) {
            if (arrayNumbers[i] == arrayNumbers[i + 1]) {
                System.out.println( arrayNumbers[i] + ", " + arrayNumbers[i + 1]);
                return true;
            }
        }
        return false;
    }
}
