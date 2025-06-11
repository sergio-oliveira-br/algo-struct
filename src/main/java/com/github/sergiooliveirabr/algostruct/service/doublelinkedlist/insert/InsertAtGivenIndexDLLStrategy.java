package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert;

import com.github.sergiooliveirabr.algostruct.exceptions.InvalidIndexException;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertAtGivenIndexDLLStrategy {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;
    private final InsertAtBeginningDLLStrategy insertAtBeginningDLLStrategy;
    private final InsertAtEndDLLStrategy insertAtEndDLLStrategy;

    @Autowired
    public InsertAtGivenIndexDLLStrategy(DoubleLinkedListService<Integer> doubleLinkedListService, InsertAtBeginningDLLStrategy insertAtBeginningDLLStrategy, InsertAtEndDLLStrategy insertAtEndDLLStrategy) {
        this.doubleLinkedListService = doubleLinkedListService;
        this.insertAtBeginningDLLStrategy = insertAtBeginningDLLStrategy;
        this.insertAtEndDLLStrategy = insertAtEndDLLStrategy;
    }

    public void insertElementByIndexDLL(int element, int index) {

        NodeDLL<Integer> newNodeDLL = new NodeDLL<>(element);
        int lengthDLL = doubleLinkedListService.size();

        if(index == 0) {
            insertAtBeginningDLLStrategy.insertElementDLL(newNodeDLL.getElement());
        }
        else if (index == lengthDLL) {
            insertAtEndDLLStrategy.insertElementDLL(newNodeDLL.getElement());
        }
        else if (index > 0 && index < lengthDLL) {
            NodeDLL<Integer> currentElement = doubleLinkedListService.getHeadDLL();
            NodeDLL<Integer> previousCurrent = null;

           for (int i = 0; i < index; i++) {
               previousCurrent = currentElement;
               currentElement = currentElement.getNext();
           }
            //Update the list
            newNodeDLL.setNext(currentElement);
            newNodeDLL.setPrevious(previousCurrent);
            previousCurrent.setNext(newNodeDLL);
            currentElement.setPrevious(newNodeDLL);
        }
        else {
            throw new InvalidIndexException();
        }
    }
}
