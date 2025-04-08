package com.github.sergiooliveirabr.algostruct.service.sort;

import com.github.sergiooliveirabr.algostruct.service.utilities.ElapsedTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertionSortService implements SortingAlgorithm {

    private final ElapsedTimeService elapsedTimeService;

    @Autowired
    public InsertionSortService(ElapsedTimeService elapsedTimeService) {
        this.elapsedTimeService = elapsedTimeService;
    }


    @Override
    public long sort(int[] array) {

        System.out.println("Executing the Insertion Sort method");

        long startTimeMillis = System.currentTimeMillis();

        for(int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int position = i - 1;

            while(position >= 0 && array[position] > currentValue) {
                array[position + 1 ] = array[position];
                position--;
            }
            array[position + 1] = currentValue;
        }
        long endTimeMillis = System.currentTimeMillis();
        long elapsedTimeMillis = endTimeMillis - startTimeMillis;

        return elapsedTimeService.formatElapsedTime(elapsedTimeMillis);
    }
}
