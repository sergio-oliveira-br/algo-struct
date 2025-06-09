package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete;

import com.github.sergiooliveirabr.algostruct.exceptions.EmptyListException;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;

@Service
public class DeleteLastElementDLLStrategy<T> implements DeleteElementStrategyDLL {

    private final DoubleLinkedListService<T> doubleLinkedListService;

    @Autowired
    public DeleteLastElementDLLStrategy(DoubleLinkedListService<T> doubleLinkedListService) {
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public void deleteElementDLL() {

        NodeDLL<T> currentTail = doubleLinkedListService.getTailDLL();
        NodeDLL<T> head = doubleLinkedListService.getHeadDLL();

        if(doubleLinkedListService.isEmpty()) {
            throw new EmptyListException();
        }
        else if (currentTail == head) {
            currentTail.setPrevious(null);
            currentTail.setNext(null);

            doubleLinkedListService.setTailDLL(null);
            doubleLinkedListService.setHeadDLL(null);
        }
        else {
            NodeDLL<T> newTail = currentTail.getPrevious();

            //disconnect
            newTail.setNext(null);
            currentTail.setPrevious(null);

            //new set
            doubleLinkedListService.setTailDLL(newTail);
        }
    }
}
