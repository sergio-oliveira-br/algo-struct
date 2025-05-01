package com.github.sergiooliveirabr.algostruct.service.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node <T> {

    T element;
    public Node next;

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public Node(T element) {
        this(element, null);
    }

    @Override
    public String toString() {
        return element + "";
    }
}
