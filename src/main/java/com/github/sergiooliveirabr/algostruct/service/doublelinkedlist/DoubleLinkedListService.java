package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class DoubleLinkedListService<T> {

    NodeDLL<T> headDLL;
    NodeDLL<T> tailDLL;

    public DoubleLinkedListService() {
        this.headDLL = null;
        this.tailDLL = null;
    }

    public boolean isEmpty() {
       return headDLL == null;
    }

    public List<T> getAllElementsFromDLL(){

        List<T> list = new ArrayList<>();
        NodeDLL<T> current = headDLL;

        while (current != null) {
            list.add(current.getElement());
            current = current.getNext();
        }
        return list;
    }
}
