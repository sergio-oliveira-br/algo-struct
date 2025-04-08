package com.github.sergiooliveirabr.algostruct.service.sort;

import com.github.sergiooliveirabr.algostruct.service.utilities.ElapsedTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TimSortService  implements SortingAlgorithm {

    private final ElapsedTimeService elapsedTimeService;

    @Autowired
    public TimSortService(ElapsedTimeService elapsedTimeService) {
        this.elapsedTimeService = elapsedTimeService;
    }

    @Override
    public long sort(int[] array) {

        System.out.println("Executing the Tim Sort method");

        long startTimeMillis = System.currentTimeMillis();

        //Arrays of int, double etc. use a modern variant of QuickSort called DualPivotQuickSort.
        Arrays.sort(array);

        long endTimeMillis = System.currentTimeMillis();
        long elapsedTimeMillis = endTimeMillis - startTimeMillis;

        return elapsedTimeService.formatElapsedTime(elapsedTimeMillis);
    }
}
