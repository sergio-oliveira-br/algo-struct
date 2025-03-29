package com.github.sergiooliveirabr.algostruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BubbleSortService {

    private final RandomNumService randomNumService;
    private final ElapsedTimeService elapsedTimeService;

    @Autowired
    public BubbleSortService(RandomNumService randomNumService,
                             ElapsedTimeService elapsedTimeService) {
        this.randomNumService = randomNumService;
        this.elapsedTimeService = elapsedTimeService;
    }

    public void bubbleSort(int[] randomNumberArray) {

        for (int i = 0; i < randomNumberArray.length - 1; i++) {

            for (int j = 0; j < randomNumberArray.length - i - 1; j++) {

                if (randomNumberArray[j] > randomNumberArray[j + 1]) {

                    int temp = randomNumberArray[j];

                    randomNumberArray[j] = randomNumberArray[j + 1];
                    randomNumberArray[j + 1] = temp;
                }
            }
        }
    }
}
