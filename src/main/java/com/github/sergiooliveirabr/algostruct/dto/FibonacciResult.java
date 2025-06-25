package com.github.sergiooliveirabr.algostruct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FibonacciResult {

    int enteredNum;
    long result;
    List<String> steps;

    public FibonacciResult(int enteredNum, long result, List<String> steps) {
        this.enteredNum = enteredNum;
        this.result = result;
        this.steps = steps;
    }
}
