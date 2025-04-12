package com.github.sergiooliveirabr.algostruct.service.duplicatecheck;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsingSetService implements DuplicateCheckInterface {

    @Override
    public boolean isDuplicate(int[] arrayNumbers) {

        System.out.println("\nExecuting the HashSet method");

        Set<Integer> seenElements = new HashSet<>();

        for (int number : arrayNumbers) {

            if (!seenElements.add(number)) {
                System.out.println("Duplicate element: " + number);
                return true;
            }
        }
       return false;
    }
}
