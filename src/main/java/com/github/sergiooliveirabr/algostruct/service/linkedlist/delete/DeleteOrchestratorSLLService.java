package com.github.sergiooliveirabr.algostruct.service.linkedlist.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeleteOrchestratorSLLService {

    private final Map<String, DeleteElementStrategy> strategyMap;

    @Autowired
    public DeleteOrchestratorSLLService(Map<String, DeleteElementStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public void deleteOrchestrator(String selectedStrategy) {

        DeleteElementStrategy deleteElementStrategy = strategyMap.get(selectedStrategy);

        if (deleteElementStrategy == null) {
            throw new IllegalArgumentException("No strategy found for " + selectedStrategy);
        }
        deleteElementStrategy.deleteElement();
    }
}
