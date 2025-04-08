package com.github.sergiooliveirabr.algostruct.service.linearsearch;

import com.github.sergiooliveirabr.algostruct.service.generator.RandomNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LinearSearchService {

    public String linearSeach (int[] arrayNumbers, int target) {

        System.out.println("Array: " + Arrays.toString(arrayNumbers));
        System.out.println("Target: " + target);

        for (int i = 0; i < arrayNumbers.length; i++) {
            if(target == arrayNumbers[i]) {
                return "Found at index: " + i;
            }
        }
        return "The number " + target +  " was not found";
    }
}
