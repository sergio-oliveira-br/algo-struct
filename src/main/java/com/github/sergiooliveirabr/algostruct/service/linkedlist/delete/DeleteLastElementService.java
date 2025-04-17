package com.github.sergiooliveirabr.algostruct.service.linkedlist.delete;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteLastElementService<T> implements DeleteElementStrategy {

    private final SinglyLinkedListService<T> singlyLinkedListService;

    @Autowired
    public DeleteLastElementService(SinglyLinkedListService<T> singlyLinkedListService){
        this.singlyLinkedListService = singlyLinkedListService;
    }

    @Override
    public void deleteElement() {

        Node current = singlyLinkedListService.getHead();
        Node tail = singlyLinkedListService.getTail();
        Node previous = null;

        if(singlyLinkedListService.getHead() == singlyLinkedListService.getTail()){
            singlyLinkedListService.setHead(null);
            singlyLinkedListService.setTail(null);
            return;
        }
        while(current != null && current != tail){
           previous = current;
           current = current.next;
        }
        if(previous != null){
            previous.next = null;
            singlyLinkedListService.setTail(previous);
        }
        else{
            singlyLinkedListService.setHead(null);
            singlyLinkedListService.setTail(null);
        }
    }
}
