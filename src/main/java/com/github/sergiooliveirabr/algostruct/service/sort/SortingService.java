package com.github.sergiooliveirabr.algostruct.service.sort;

import com.github.sergiooliveirabr.algostruct.service.utilities.ElapsedTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SortingService {

    private final ElapsedTimeService elapsedTimeService;
    private final Map<String, SortingAlgorithm> sortingAlgorithmMap;

    @Autowired
    public SortingService(ElapsedTimeService elapsedTimeService,
                          Map<String, SortingAlgorithm> sortingAlgorithmMap) {

        this.elapsedTimeService = elapsedTimeService;
        this.sortingAlgorithmMap = sortingAlgorithmMap;
    }

    public Map<String, Long> executeSortingAlgorithms(int[] array,
                                                      List<String> algorithmSelected) {

        System.out.println("\n[Service Class] - Available keys in sortingAlgorithmMap: " + sortingAlgorithmMap.keySet());
        System.out.println("[Service Class] - Start Executing: " + algorithmSelected);

        Map<String, Long> executionTimes = new HashMap<>();

        for (String algorithmName : algorithmSelected) {

            SortingAlgorithm algorithm = sortingAlgorithmMap.get(algorithmName);

            if (algorithm != null) {
                long elapsedTime = elapsedTimeService.formatElapsedTime(algorithm.sort(array.clone()));
                executionTimes.put(algorithmName, elapsedTime);
            }
        }
        return executionTimes;
    }
}
