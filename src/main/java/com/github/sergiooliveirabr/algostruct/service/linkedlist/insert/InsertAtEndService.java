package com.github.sergiooliveirabr.algostruct.service.linkedlist.insert;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertAtEndService implements InsertElementStrategy {

    private final SinglyLinkedListService<Integer> singlyLinkedListService;

    @Autowired
    public InsertAtEndService(SinglyLinkedListService<Integer> singlyLinkedListService) {
        this.singlyLinkedListService = singlyLinkedListService;
    }

    @Override
    public void insertElement(int value) {

        Node<Integer> newNode = new Node<>(value);

        if(singlyLinkedListService.isEmpty()){
            singlyLinkedListService.setHead(newNode);
            singlyLinkedListService.setTail(newNode);
        }
        else{
            singlyLinkedListService.getTail().next = newNode;
            singlyLinkedListService.setTail(newNode);
        }
    }
}
