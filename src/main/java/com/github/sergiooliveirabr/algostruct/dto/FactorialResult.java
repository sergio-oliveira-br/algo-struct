package com.github.sergiooliveirabr.algostruct.dto;

import java.util.List;

public class FactorialResult {

    private int number;
    private long result;
    private List<String> steps;

    public FactorialResult(int number, long result, List<String> steps) {
        this.number = number;
        this.result = result;
        this.steps = steps;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
