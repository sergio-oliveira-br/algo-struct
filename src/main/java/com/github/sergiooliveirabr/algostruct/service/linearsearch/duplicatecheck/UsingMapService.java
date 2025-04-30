package com.github.sergiooliveirabr.algostruct.service.linearsearch.duplicatecheck;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsingMapService implements DuplicateCheckInterface {

    @Override
    public boolean isDuplicate(int[] arrayNumbers) {

        System.out.println("\nExecuting the HashMap method");

        Map<Integer, Integer> map = new HashMap<>();

        for(int number : arrayNumbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);

            if(map.get(number) != 1) {
                System.out.println("Duplicate key: " + number);
                return true;
            }
        }
        return false;
    }
}
