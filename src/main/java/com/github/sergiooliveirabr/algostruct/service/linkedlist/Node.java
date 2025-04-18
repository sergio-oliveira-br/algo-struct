package com.github.sergiooliveirabr.algostruct.service.linkedlist;

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

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return element + "";
    }
}
