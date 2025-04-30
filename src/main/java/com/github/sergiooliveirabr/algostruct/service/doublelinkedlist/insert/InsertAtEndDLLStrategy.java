package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;

public class InsertAtEndDLLStrategy<T> implements InsertElementDLLStrategy<T> {

    private DoubleLinkedListService<T> doubleLinkedListService;


    public InsertAtEndDLLStrategy(DoubleLinkedListService<T>  doubleLinkedListService){
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public void insertElementDLL(T element) {

        //Create a new Node with the element entered
        NodeDLL<T> newNode = new NodeDLL<>(element);

        //If there is no element in the list
        if(doubleLinkedListService.isEmpty()){
            doubleLinkedListService.setHeadDLL(newNode);
            doubleLinkedListService.setTailDLL(newNode);
            newNode.setPrevious(null);
            newNode.setNext(null);
        }

        //If there is at least one element in the list
        else {
            NodeDLL<T> currentNode = doubleLinkedListService.getTailDLL();

            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
            doubleLinkedListService.setTailDLL(newNode);
        }
    }
}
