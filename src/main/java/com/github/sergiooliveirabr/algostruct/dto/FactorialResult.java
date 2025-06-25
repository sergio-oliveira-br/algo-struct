package com.github.sergiooliveirabr.algostruct.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FactorialResult {

    private int number;
    private long result;
    private List<String> steps;

    public FactorialResult(int number, long result, List<String> steps) {
        this.number = number;
        this.result = result;
        this.steps = steps;
    }
}
