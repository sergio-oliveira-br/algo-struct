package com.github.sergiooliveirabr.algostruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BubbleSortService implements SortingAlgorithm {

    private final ElapsedTimeService elapsedTimeService;

    @Autowired
    public BubbleSortService(ElapsedTimeService elapsedTimeService) {
        this.elapsedTimeService = elapsedTimeService;
    }

    @Override
    public long sort(int[] array) {

        System.out.println("Bubble Sort");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        return elapsedTimeService.formatElapsedTime(elapsedTime);
    }

    @Override
    public String getAlgorithmName() {
        return "Bubble Sort";
    }
}
