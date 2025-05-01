package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
