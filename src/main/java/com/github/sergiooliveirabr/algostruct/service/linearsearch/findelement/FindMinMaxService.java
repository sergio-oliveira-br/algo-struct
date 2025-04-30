package com.github.sergiooliveirabr.algostruct.service.linearsearch.findelement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FindMinMaxService {

    private final Map<String, FindMinMaxInterface> minMaxMap;

    @Autowired
    public FindMinMaxService(Map<String, FindMinMaxInterface> minMaxMap) {
        this.minMaxMap = minMaxMap;
    }

    public Map<String, Integer> executeFindMinMaxAlgorithms(int[] arrayNumbers,
                                                            List<String> algorithmSelected) {

        System.out.println("\n[Service Class] - Available keys in minMaxMap:" + minMaxMap.keySet());
        System.out.println("User has selected: " + algorithmSelected);

        Map<String, Integer> result = new HashMap<>();

        for (String key : algorithmSelected) {
            FindMinMaxInterface findMinMaxInterface = minMaxMap.get(key);

            if(findMinMaxInterface != null){
                result.put(key, findMinMaxInterface.findMinMax(arrayNumbers.clone()));
            }
        }
        return result;
    }
}
