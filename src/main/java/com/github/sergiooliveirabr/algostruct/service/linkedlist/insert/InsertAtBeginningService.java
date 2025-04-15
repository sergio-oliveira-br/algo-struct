package com.github.sergiooliveirabr.algostruct.service.linkedlist.insert;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertAtBeginningService<T> implements InsertElementStrategy<T> {

    private final SinglyLinkedListService<T> singlyLinkedListService;

    @Autowired
    public InsertAtBeginningService(SinglyLinkedListService<T> singlyLinkedListService) {
        this.singlyLinkedListService = singlyLinkedListService;
    }

    @Override
    public void insertElement(T value) {

        Node<T> newNode = new Node<>(value);

        if(singlyLinkedListService.isEmpty()){
            singlyLinkedListService.setHead(newNode);
            singlyLinkedListService.setTail(newNode);
        }
        else{
            newNode.next = singlyLinkedListService.getHead();
            singlyLinkedListService.setHead(newNode);
        }
    }
}
