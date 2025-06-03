package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeleteOrchestratorDLLService<T> {

    private final Map<String, DeleteElementStrategyDLL> deleteElementStrategyDLLMap;
    private final DoubleLinkedListService<Integer> doubleLinkedListService;

    @Autowired
    public DeleteOrchestratorDLLService(Map<String, DeleteElementStrategyDLL> deleteElementStrategyDLLMap,
                                        DoubleLinkedListService<Integer> doubleLinkedListService) {

        this.deleteElementStrategyDLLMap = deleteElementStrategyDLLMap;
        this.doubleLinkedListService = doubleLinkedListService;
    }

    public void deleteOrchestratorDLL(String selectedStrategy) {

        DeleteElementStrategyDLL deleteStrategy = deleteElementStrategyDLLMap.get(selectedStrategy);

        if (deleteStrategy == null) {
            throw new IllegalArgumentException("Strategy " + selectedStrategy + " not found");
        }
        else {
            deleteStrategy.deleteElementDLL();
        }
    }
}
