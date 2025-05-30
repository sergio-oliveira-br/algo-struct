package com.github.sergiooliveirabr.algostruct.service.linkedlist;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
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
        
        for (Node current = head; current != null; current = current.next) {
            count++;
        }
        return count;
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
