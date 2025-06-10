package com.github.sergiooliveirabr.algostruct.service.linkedlist.delete;

import com.github.sergiooliveirabr.algostruct.exceptions.EmptyListException;
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

        if (singlyLinkedListService.isEmpty()){
            throw new EmptyListException();
        }

        if(singlyLinkedListService.getHead() == singlyLinkedListService.getTail()){
            singlyLinkedListService.setHead(null);
            singlyLinkedListService.setTail(null);
            return;
        }

        Node current = singlyLinkedListService.getHead();

        while(current.next != singlyLinkedListService.getTail()){
           current = current.next;
        }
        current.next = null;
        singlyLinkedListService.setTail(current);
    }
}
