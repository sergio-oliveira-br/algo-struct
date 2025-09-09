package com.github.sergiooliveirabr.algostruct.service.calculator;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class FormatValueService {

    public String formatCurrency(Double value) {

        if(value == null || value < 0) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(value);
    }
}
