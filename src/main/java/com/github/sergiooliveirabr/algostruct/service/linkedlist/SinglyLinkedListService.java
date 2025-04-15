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
