package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete;

import com.github.sergiooliveirabr.algostruct.exceptions.EmptyListException;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
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

        NodeDLL<Integer> current = doubleLinkedListService.getHeadDLL();

        if (current == null) {
            System.out.println("the current list is empty.");
            throw new EmptyListException();
        }
    }
}
