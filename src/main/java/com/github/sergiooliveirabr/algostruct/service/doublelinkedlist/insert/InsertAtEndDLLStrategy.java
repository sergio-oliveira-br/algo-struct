package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertAtEndDLLStrategy implements InsertElementDLLStrategy {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;

    @Autowired
    public InsertAtEndDLLStrategy(DoubleLinkedListService<Integer> doubleLinkedListService){
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public void insertElementDLL(int element) {

        //Create a new Node with the element entered
        NodeDLL<Integer> newNode = new NodeDLL<>(element);

        //If there is no element in the list
        if(doubleLinkedListService.isEmpty()){
            doubleLinkedListService.setHeadDLL(newNode);
            doubleLinkedListService.setTailDLL(newNode);
            newNode.setPrevious(null);
            newNode.setNext(null);
        }

        //If there is at least one element in the list
        else {
            NodeDLL<Integer> currentNode = doubleLinkedListService.getTailDLL();

            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
            doubleLinkedListService.setTailDLL(newNode);
        }
    }
}
