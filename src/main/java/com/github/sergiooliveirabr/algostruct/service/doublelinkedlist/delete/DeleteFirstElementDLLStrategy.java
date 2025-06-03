package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;

@Service
public class DeleteFirstElementDLLStrategy<T> implements DeleteElementStrategyDLL{

    private final DoubleLinkedListService<T> doubleLinkedListService;

    @Autowired
    public DeleteFirstElementDLLStrategy(DoubleLinkedListService<T> doubleLinkedListService) {
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public void deleteElementDLL() {

        NodeDLL<T> head = doubleLinkedListService.getHeadDLL();
        NodeDLL<T> tail = doubleLinkedListService.getTailDLL();

        if(head == null) {
            throw new EmptyStackException();
        }
        else if (head == tail) {
           doubleLinkedListService.setHeadDLL(null);
           doubleLinkedListService.setTailDLL(null);

           head.setPrevious(null);
           tail.setPrevious(null);
        }
        else {
            NodeDLL<T> currentNextHead = head.getNext();

            doubleLinkedListService.setHeadDLL(currentNextHead);
            currentNextHead.setPrevious(null);
            head.setNext(null);
        }
    }
}
