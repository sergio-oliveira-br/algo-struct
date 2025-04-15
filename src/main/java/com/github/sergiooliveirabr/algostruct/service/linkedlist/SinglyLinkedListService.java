package com.github.sergiooliveirabr.algostruct.service.linkedlist;

import org.springframework.stereotype.Service;

@Service
public class SinglyLinkedListService<T> {

    private Node<T> head;
    private Node tail;

    public SinglyLinkedListService() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size(){

        int count = 0;

        if (!isEmpty()) {
            for (Node current = head; current != null; current = current.next) {
                count++;
            }
            return count;
        }
        return count;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {

        String str = "";
        Node <T> current = head;

        while(current != null){
            if(current == head){
                str += "" + current;
            }
            else{
                str += " -> " + current;
            }
            current = current.next;

        }
        return " Singly Linked List: { " + str + " }";
    }
}
