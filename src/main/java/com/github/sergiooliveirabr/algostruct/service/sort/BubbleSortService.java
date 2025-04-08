package com.github.sergiooliveirabr.algostruct.service.sort;

import com.github.sergiooliveirabr.algostruct.service.utilities.ElapsedTimeService;
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

        System.out.println("Executing the Bubble Sort method");

        long startTimeMillis = System.currentTimeMillis();

        for (int outerIndex = 0; outerIndex < array.length - 1; outerIndex++) {

            boolean elementsSwapped = false;

            for (int innerIndex = 0; innerIndex < array.length - outerIndex - 1; innerIndex++) {

                if (array[innerIndex] > array[innerIndex + 1]) {
                    int temporaryValue = array[innerIndex];

                    array[innerIndex] = array[innerIndex + 1];
                    array[innerIndex + 1] = temporaryValue;
                    
                    elementsSwapped = true;
                }
            }
            if (!elementsSwapped) break;
        }
        long endTimeMillis = System.currentTimeMillis();
        long elapsedTimeMillis = endTimeMillis - startTimeMillis;

        return elapsedTimeService.formatElapsedTime(elapsedTimeMillis);
    }
}
