package com.github.sergiooliveirabr.algostruct.service.linkedlist.delete;

import com.github.sergiooliveirabr.algostruct.exceptions.EmptyListException;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFirstElementService<T> implements DeleteElementStrategy {

    private final SinglyLinkedListService<T> singlyLinkedListService;

    @Autowired
    public DeleteFirstElementService(SinglyLinkedListService<T> singlyLinkedListService) {
        this.singlyLinkedListService = singlyLinkedListService;
    }

    @Override
    public void deleteElement() {

        if (!singlyLinkedListService.isEmpty()){
            singlyLinkedListService.setHead(singlyLinkedListService.getHead().next);

            if(singlyLinkedListService.getHead() == null){
                singlyLinkedListService.setTail(null);
            }
        }
        else {
            throw new EmptyListException();
        }
    }
}
