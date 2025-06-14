package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.search;

import com.github.sergiooliveirabr.algostruct.exceptions.EmptyListException;
import com.github.sergiooliveirabr.algostruct.exceptions.InvalidIndexException;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetElementByIndexDLLStrategy implements GetElementStrategy<Integer> {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;

    @Autowired
    public GetElementByIndexDLLStrategy(DoubleLinkedListService<Integer> doubleLinkedListService) {
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public Integer getElement(int indexEntered) {

        int size = doubleLinkedListService.size();
        int indexElement = 0;

        if (doubleLinkedListService.isEmpty()) {
            throw new EmptyListException();
        }
        else if (indexEntered >= size || indexEntered < 0) {
            throw new InvalidIndexException("Index out of bounds. You are looking for index: " +
                    indexEntered + ", the size is " + size +
                    ". \nIt's important to remember that the initial index begins with zero, not one");
        }
        else {
            if(indexEntered < size / 2) {
                NodeDLL<Integer> current = doubleLinkedListService.getHeadDLL();

                while (indexEntered != indexElement) {
                    current = current.getNext();
                    indexElement++;
                }
                return current.getElement();
            }
            else {
                NodeDLL<Integer> current = doubleLinkedListService.getTailDLL();
                indexElement = size - 1;
                while (indexEntered != indexElement) {
                    current = current.getPrevious();
                    indexElement--;
                }
                return current.getElement();
            }
        }
    }
}
