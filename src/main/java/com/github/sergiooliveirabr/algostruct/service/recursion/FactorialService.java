package com.github.sergiooliveirabr.algostruct.service.recursion;

import com.github.sergiooliveirabr.algostruct.dto.FactorialResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactorialService {

    public FactorialResult calculateFactorialWithSteps(int number) {

        if (number < 0) {
            throw  new IllegalArgumentException("Must be a positive integer");
        }
        List<String> steps = new ArrayList<>();
        long result = calculateFactorialRecursive (number, steps);

        return new FactorialResult(number, result, steps);
    }

    private long calculateFactorialRecursive (int number, List<String> steps) {

        if (number == 0) {
            steps.add("0! = 1");
            return 1;
        }
        long partialResult = calculateFactorialRecursive (number - 1, steps);
        long finalResult = partialResult * number;
        steps.add(number + "! = " + number + " * " + (number - 1) + "! = " + finalResult);
        
        return finalResult;
    }
}
