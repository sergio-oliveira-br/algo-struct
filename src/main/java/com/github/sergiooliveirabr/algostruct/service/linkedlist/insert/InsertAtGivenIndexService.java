package com.github.sergiooliveirabr.algostruct.service.linkedlist.insert;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertAtGivenIndexService<T> {

    //injetar os componentes
    private final InsertAtBeginningService insertAtBeginningService;
    private final InserteAtEndService inserteAtEndService;
    private final SinglyLinkedListService singlyLinkedListService;

    @Autowired
    public InsertAtGivenIndexService(InsertAtBeginningService insertAtBeginningService,
                                     InserteAtEndService inserteAtEndService,
                                     SinglyLinkedListService singlyLinkedListService) {

        this.insertAtBeginningService = insertAtBeginningService;
        this.inserteAtEndService = inserteAtEndService;
        this.singlyLinkedListService = singlyLinkedListService;
    }

    public void InsertAtGivenIndex(int index, T element) {

        Node<T> head = singlyLinkedListService.getHead();
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> newNode = new Node<>(element);
        int size = singlyLinkedListService.size();

        if (index == 0) {
            insertAtBeginningService.insertElement(element);

        } else if (index == size) {
            inserteAtEndService.insertElement(element);

        } else if (index > 0 && index < size) {
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
                System.out.println("current.getElement() FOR --> " + current);
            }
            newNode.next = current;
            previous.next = newNode;

        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
