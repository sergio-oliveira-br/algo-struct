package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.duplicate;

import com.github.sergiooliveirabr.algostruct.exceptions.EmptyListException;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.NodeDLL;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RemoveDuplicateDLL implements RemoveDuplicatesInterface {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;

    @Autowired
    public RemoveDuplicateDLL(DoubleLinkedListService<Integer> doubleLinkedListService) {
        this.doubleLinkedListService = doubleLinkedListService;
    }

    @Override
    public void removeDuplicatesDLLStrategy() {
        
        if (doubleLinkedListService.isEmpty()) throw new EmptyListException();

        Set<Integer> seenElements = new HashSet<>();
        NodeDLL<Integer> current = doubleLinkedListService.getHeadDLL();

        while (current != null) {

            if (!seenElements.add(current.getElement())){

                if (current.getElement().equals(current.getPrevious().getElement())) {
                    System.out.println("Elemento igual encontrado na sequencia");

                    //The Duplicate is not the tail, and it is in sequence
                    if (current.getNext() != null) {
                        System.out.println("Elimnando elemento que NÃO É A CALDA");

                        NodeDLL<Integer> previous = current.getPrevious();
                        NodeDLL<Integer> next = current.getNext();

                        previous.setNext(current.getNext());
                        next.setPrevious(previous);

                    }
                    else {
                        System.out.println("Elimnando a CALDA");
                        NodeDLL<Integer> previous = current.getPrevious();
                        previous.setNext(null);
                        doubleLinkedListService.setTailDLL(previous);
                    }
                }
                System.out.println("************");
                System.out.println("Current element " + current.getElement());
                System.out.println("Elementos repetidos:  " + seenElements);

                //se é repedito nao em sequencia é a calda é um deles
                if (current.getNext().equals(doubleLinkedListService.getTailDLL())) {
                    System.out.println("entrei na calda");
                    System.out.println("previous do current " + current.getPrevious().getElement());
                    System.out.println("next " + current.getNext().getElement());
                }



            }
            //System.out.println("current " + current.getElement() + " getting next " + current.getNext().getElement());
            current = current.getNext();
        }
    }
}
