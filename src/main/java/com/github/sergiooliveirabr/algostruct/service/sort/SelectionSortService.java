package com.github.sergiooliveirabr.algostruct.service.sort;

import com.github.sergiooliveirabr.algostruct.service.utilities.ElapsedTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectionSortService implements SortingAlgorithm {

    private final ElapsedTimeService elapsedTimeService;

    @Autowired
    public SelectionSortService(ElapsedTimeService elapsedTimeService) {
        this.elapsedTimeService = elapsedTimeService;
    }

    @Override
    public long sort(int[] array) {
        System.out.println("Executing the Selection Sort method");

        long startTimeMillis = System.currentTimeMillis();

        for(int sortedIndex = 0; sortedIndex < array.length; sortedIndex++) {

            int smallestElement = sortedIndex;

            for(int queryIndex = sortedIndex + 1; queryIndex < array.length; queryIndex++) {
                if (array[queryIndex] < array[smallestElement]) {
                    smallestElement = queryIndex;
                }
            }

            int temporaryValue = array[sortedIndex];

            array[sortedIndex] = smallestElement;
            array[smallestElement] = temporaryValue;
        }

        long endTimeMillis = System.currentTimeMillis();
        long elapsedTimeMillis = endTimeMillis - startTimeMillis;

        return elapsedTimeService.formatElapsedTime(elapsedTimeMillis);
    }
}
