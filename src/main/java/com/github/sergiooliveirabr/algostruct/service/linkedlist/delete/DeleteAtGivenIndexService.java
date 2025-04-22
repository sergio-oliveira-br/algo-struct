package com.github.sergiooliveirabr.algostruct.service.linkedlist.delete;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAtGivenIndexService<T> {

    private final DeleteFirstElementService<T> deleteFirstElementService;
    private final DeleteLastElementService<T> deleteLastElementService;
    private final SinglyLinkedListService<T> singlyLinkedListService;

    @Autowired
    public DeleteAtGivenIndexService(DeleteFirstElementService<T> deleteFirstElementService,
                                     DeleteLastElementService<T> deleteLastElementService,
                                     SinglyLinkedListService<T> singlyLinkedListService) {

        this.deleteFirstElementService = deleteFirstElementService;
        this.deleteLastElementService = deleteLastElementService;
        this.singlyLinkedListService = singlyLinkedListService;
    }

    public void deleteAtGivenIndex(int index) {

        Node<T> current = singlyLinkedListService.getHead();
        Node<T> previous = null;
        int size = singlyLinkedListService.size();

        if(index == 0){
            deleteFirstElementService.deleteElement();
        }
        else if(index == size){
            deleteLastElementService.deleteElement();
        }
        else if (index >= 1 && index < size) {
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            current = current.next;
            previous.next = current;

        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
