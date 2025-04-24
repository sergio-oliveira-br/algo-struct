package com.github.sergiooliveirabr.algostruct.service.linkedlist.reverse;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ReverseListService<T> {

    private final SinglyLinkedListService<T> singlyLinkedListService;

    @Autowired
    public ReverseListService(SinglyLinkedListService<T> singlyLinkedListService) {
        this.singlyLinkedListService = singlyLinkedListService;
    }

    public void reverseList() {

        Node<T> head = singlyLinkedListService.getHead();
        Node<T> tail = singlyLinkedListService.getTail();
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> tempNextNode = null;

        SinglyLinkedListService<T> newListReversed = new SinglyLinkedListService<>();
        int listSize = singlyLinkedListService.size();

        if(listSize == 0) {
            throw new NoSuchElementException();
        }
        else if(listSize == 1){
           throw new NoSuchElementException();
        }
        else if (listSize > 1) {
            singlyLinkedListService.setTail(head);

            while (current != null) {
                tempNextNode = current.next;
                current.next = previous;
                previous = current;
                current = tempNextNode;

                System.out.println("previous: " + previous);
                System.out.println("current: " + current);
                System.out.println("tempNextNode: " + tempNextNode);
            }
            singlyLinkedListService.setHead(previous);
        }
    }
}
