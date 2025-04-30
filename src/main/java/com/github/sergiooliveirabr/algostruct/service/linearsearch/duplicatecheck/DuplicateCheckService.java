package com.github.sergiooliveirabr.algostruct.service.linearsearch.duplicatecheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DuplicateCheckService {

    private final Map<String, DuplicateCheckInterface> duplicateCheckMap;

    @Autowired
    public DuplicateCheckService(Map<String, DuplicateCheckInterface> duplicateCheckMap) {
        this.duplicateCheckMap = duplicateCheckMap;
    }

    public Map<String, Boolean> executeDuplicateCheckAlgorithms(int[] arrayNumbers,
                                                                List<String> algorithmSelected) {

        System.out.println("\n[Service Class] - Available keys in duplicateCheckMap:" + duplicateCheckMap.keySet());
        System.out.println("User has selected: " + algorithmSelected);

        Map<String, Boolean> result = new HashMap<>();
        for (String key: algorithmSelected) {
            DuplicateCheckInterface duplicateCheckInterface = duplicateCheckMap.get(key);

            if (duplicateCheckInterface != null) {
                result.put(key, duplicateCheckInterface.isDuplicate(arrayNumbers.clone()));
            }
        }
        return result;
    }
}
