package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Getter
@Service
public class InsertOrchestratorServiceDLL {

    private final Map<String, InsertElementDLLStrategy> insertElementDLLStrategyMap;

    @Autowired
    public InsertOrchestratorServiceDLL(Map<String, InsertElementDLLStrategy> insertElementDLLStrategyMap) {
        this.insertElementDLLStrategyMap = insertElementDLLStrategyMap;
    }

    public void insertElementDLLStrategyMap(int element, String selectedStrategy) {

        InsertElementDLLStrategy insertElementDLLStrategy = insertElementDLLStrategyMap.get(selectedStrategy);

        if(insertElementDLLStrategy == null) {
            throw new RuntimeException("No strategy was selected");
        }
        insertElementDLLStrategy.insertElementDLL(element);
    }
}
