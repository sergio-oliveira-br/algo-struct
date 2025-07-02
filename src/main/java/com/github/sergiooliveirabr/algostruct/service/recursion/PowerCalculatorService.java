package com.github.sergiooliveirabr.algostruct.service.recursion;

import org.springframework.stereotype.Service;

@Service
public class PowerCalculatorService {

    public int calculatePower(int base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        return base * calculatePower(base, exponent - 1);
    }
}
