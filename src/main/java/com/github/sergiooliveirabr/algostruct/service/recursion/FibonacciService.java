package com.github.sergiooliveirabr.algostruct.service.recursion;

import com.github.sergiooliveirabr.algostruct.dto.FibonacciResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {

    public FibonacciResult displayFibonacciWithSteps(int number) {

        if(number < 0) {
            throw new IllegalArgumentException("The entered number cannot be negative");
        }

        List<String>steps = new ArrayList<>();
        long result =calculateFibonacciRecursive(number, steps, 0 );

        return new FibonacciResult(number, result, steps);
    }

    public long calculateFibonacciRecursive(int enteredNumber, List<String>steps, int depth) {

        String indent = "  ".repeat(depth); // Dois espaços por nível de profundidade
        steps.add(indent + "--> Chamando F (" + (enteredNumber) + ")");


        if (enteredNumber == 0 || enteredNumber == 1) {
            steps.add(indent + "<-- F(" + enteredNumber + ") (Caso Base) retorna " + enteredNumber);
            return enteredNumber;
        }

        long firstPartial = calculateFibonacciRecursive(enteredNumber - 1, steps, depth + 1);
        steps.add( indent + "F(" + enteredNumber + ") obteve " + firstPartial + " de F(" + (enteredNumber - 1) + ")");

        long secondPartial = calculateFibonacciRecursive(enteredNumber - 2, steps, depth + 1);
        steps.add( indent + "F(" + enteredNumber + ") obtebe " + secondPartial + " de F(" + (enteredNumber - 2) + ")");

        long result = firstPartial + secondPartial;
        steps.add(indent + "<-- F(" + enteredNumber + ") retorna " + result + " (" + firstPartial + " + " + secondPartial + ")");

        return result;
    }
}
