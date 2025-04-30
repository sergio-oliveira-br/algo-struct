package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist;

import lombok.Data;

@Data
public class NodeDLL<T> {

    T element;
    NodeDLL<T> next = null;
    NodeDLL<T> previous = null;

    public NodeDLL(T element) {
        this.element = element;
    }

    public NodeDLL(T element, NodeDLL<T> next, NodeDLL<T> previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }
}
