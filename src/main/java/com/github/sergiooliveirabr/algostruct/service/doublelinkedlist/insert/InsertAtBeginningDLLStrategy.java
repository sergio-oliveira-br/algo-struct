package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertAtBeginningDLLStrategy implements InsertElementDLLStrategy {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;

    @Autowired
    public InsertAtBeginningDLLStrategy(DoubleLinkedListService<Integer> doubleLinkedListService) {
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public void insertElementDLL(int element) {

        NodeDLL<Integer> newNodeDLL = new NodeDLL<>(element);

        int lengthDDL = doubleLinkedListService.size();

        if(lengthDDL == 0) {
            doubleLinkedListService.setHeadDLL(newNodeDLL);
            newNodeDLL.setPrevious(null);

            doubleLinkedListService.setTailDLL(newNodeDLL);
            newNodeDLL.setNext(null);
        }
        else if (lengthDDL > 1) {
            NodeDLL<Integer> oldHeadDLL = doubleLinkedListService.getHeadDLL();

            oldHeadDLL.setPrevious(newNodeDLL);
            newNodeDLL.setNext(oldHeadDLL);

            doubleLinkedListService.setHeadDLL(newNodeDLL);
            newNodeDLL.setPrevious(null);
        }
    }
}
