package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete;

import com.github.sergiooliveirabr.algostruct.exceptions.ElementNotFoundException;
import com.github.sergiooliveirabr.algostruct.exceptions.EmptyListException;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteByValueDLLService implements DeleteByValueStrategyDLL {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;
    private final DeleteFirstElementDLLStrategy<Integer> deleteFirstElementDLLStrategy;
    private final DeleteLastElementDLLStrategy<Integer> deleteLastElementDLLStrategy;

    @Autowired
    public DeleteByValueDLLService(DoubleLinkedListService<Integer> doubleLinkedListService,
                                   DeleteFirstElementDLLStrategy<Integer> deleteFirstElementDLLStrategy,
                                   DeleteLastElementDLLStrategy<Integer> deleteLastElementDLLStrategy) {

        this.doubleLinkedListService = doubleLinkedListService;
        this.deleteFirstElementDLLStrategy = deleteFirstElementDLLStrategy;
        this.deleteLastElementDLLStrategy = deleteLastElementDLLStrategy;
    }

    @Override
    public void deleteByValueDLL(int value) {

        //Handle list empty
        if (doubleLinkedListService.isEmpty()) {
            throw new EmptyListException("Cannot delete by value from an empty list.");
        }

        //Go through the list to find the element
        else {
            NodeDLL<Integer> current = doubleLinkedListService.getHeadDLL();
            boolean elementWasDeleted = false;

            while (current != null) {
                if (current.getElement() == value) {

                    //The element exist and is the head
                    if (current.getElement().equals(doubleLinkedListService.getHeadDLL().getElement())) {
                        deleteFirstElementDLLStrategy.deleteElementDLL();
                    }

                    //the element exist and is the tail
                    else if (current.getElement().equals(doubleLinkedListService.getTailDLL().getElement())) {
                        deleteLastElementDLLStrategy.deleteElementDLL();
                    }

                    //the element is in the middle of the list
                    else {
                        NodeDLL<Integer> previous = current.getPrevious();
                        NodeDLL<Integer> next = current.getNext();

                        previous.setNext(next);
                        next.setPrevious(previous);

                        current.setNext(null);
                        current.setPrevious(null);
                    }
                    elementWasDeleted = true;
                    break;
                }
                current = current.getNext();
            }

            //The element is not in the list
            if (!elementWasDeleted) {
                throw new ElementNotFoundException("Element with value " + value + " not found in the list.");
            }
        }
    }
}
