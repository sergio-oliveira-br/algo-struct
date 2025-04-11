package com.github.sergiooliveirabr.algostruct.service.duplicatecheck;

import org.springframework.stereotype.Service;

@Service
public class BruteForceService implements DuplicateCheckInterface {

    @Override
    public boolean isDuplicate(int[] arrayNumbers) {

        System.out.println("\nExecuting the Brute Force method");

        for(int i = 0; i < arrayNumbers.length; i++) {
            int currentNumber = arrayNumbers[i];
           for(int j = i + 1; j < arrayNumbers.length; j++) {
               if(currentNumber == arrayNumbers[j]) {
                   return true;
               }
           }
        }
        return false;
    }
}
