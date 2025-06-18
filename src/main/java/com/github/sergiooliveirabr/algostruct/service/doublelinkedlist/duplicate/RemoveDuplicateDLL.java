package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.duplicate;

import com.github.sergiooliveirabr.algostruct.exceptions.EmptyListException;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RemoveDuplicateDLL implements RemoveDuplicatesInterface {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;

    @Autowired
    public RemoveDuplicateDLL(DoubleLinkedListService<Integer> doubleLinkedListService) {
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public void removeDuplicatesDLLStrategy() {
        
        if (doubleLinkedListService.isEmpty()) throw new EmptyListException();

        Set<Integer> seenElements = new HashSet<>();
        NodeDLL<Integer> current = doubleLinkedListService.getHeadDLL();

        while(current != null) {
            NodeDLL<Integer> next = current.getNext();

            if (!seenElements.add(current.getElement())) {
                NodeDLL<Integer> previous = current.getPrevious();
                //tail
                if (next == null){
                    previous.setNext(null);
                    doubleLinkedListService.setTailDLL(previous);
                }
                //not tail
                else {
                    previous.setNext(next);
                    next.setPrevious(previous);
                }
            }
            current = current.getNext();
        }
    }
}
