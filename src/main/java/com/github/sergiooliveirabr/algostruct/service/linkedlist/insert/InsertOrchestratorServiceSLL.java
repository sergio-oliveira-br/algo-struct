package com.github.sergiooliveirabr.algostruct.service.linkedlist.insert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InsertOrchestratorServiceSLL {

    private final Map<String, InsertElementStrategy> insertElementStrategyMap;

    @Autowired
    public InsertOrchestratorServiceSLL(Map<String, InsertElementStrategy> insertElementStrategyMap) {
        this.insertElementStrategyMap = insertElementStrategyMap;
    }

    public void insertOrchestrator(int element, String selectedStrategy) {

        InsertElementStrategy insertElementStrategy = insertElementStrategyMap.get(selectedStrategy);

        if (insertElementStrategy == null) {
            throw new RuntimeException("Strategy " + selectedStrategy + " not found");
        }

        insertElementStrategy.insertElement(element);
    }
}
