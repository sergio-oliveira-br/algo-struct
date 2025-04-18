package com.github.sergiooliveirabr.algostruct.service.linkedlist.search;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByValueService<T> {

    private final SinglyLinkedListService<T> singlyLinkedListService;

    @Autowired
    public FindByValueService(SinglyLinkedListService<T> singlyLinkedListService) {
        this.singlyLinkedListService = singlyLinkedListService;
    }

    public boolean findByValue(int value){

        Node<T> head = singlyLinkedListService.getHead();
        Node currentNode = head;

        if(head == null){
            return false;
        }
        else if (head.getElement().equals(value)) {
            return true;
        }
        while (currentNode != null) {
            if (currentNode.getElement().equals(value)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
}
