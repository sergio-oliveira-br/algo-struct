package com.github.sergiooliveirabr.algostruct.service.linkedlist.search;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindNodeService<T> {

    private final SinglyLinkedListService<T> singlyLinkedListService;

    @Autowired
    public FindNodeService(SinglyLinkedListService<T> singlyLinkedListService) {
        this.singlyLinkedListService = singlyLinkedListService;
    }

    public Node<T> findNode(int value) {

        Node<T> head = singlyLinkedListService.getHead();
        Node<T> current = head;

        while (current != null) {

            if(current.getElement().equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
