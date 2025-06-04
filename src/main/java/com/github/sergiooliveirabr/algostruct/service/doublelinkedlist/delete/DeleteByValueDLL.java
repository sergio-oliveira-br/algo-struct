package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteByValueDLL implements DeleteByValueStrategyDLL {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;

    @Autowired
    public DeleteByValueDLL(DoubleLinkedListService<Integer> doubleLinkedListService) {
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public void deleteByValueDLL(int value) {

    }
}
