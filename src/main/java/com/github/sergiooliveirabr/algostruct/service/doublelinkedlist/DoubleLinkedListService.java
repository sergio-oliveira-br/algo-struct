package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
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

    public int size() {

        int length = 0;
        NodeDLL<T> current = headDLL;

        if (!isEmpty()) {
            while (current != null) {
                current = current.getNext();
                length++;
            }
        }
        return length;
    }
}
