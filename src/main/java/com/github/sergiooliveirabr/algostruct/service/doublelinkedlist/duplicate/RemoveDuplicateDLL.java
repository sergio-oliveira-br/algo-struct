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

            System.out.println("adicionando os elementos: " + seenElements);

            if (!seenElements.add(current.getElement())){
                System.out.println("!elementos! " + seenElements);
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

                //se é repedito nao em sequencia é a calda é um deles
                if (current.getElement().equals(doubleLinkedListService.getTailDLL().getElement())) {

                    NodeDLL<Integer> previous = current.getPrevious();
                    previous.setNext(null);
                    doubleLinkedListService.setTailDLL(previous);
                }
                else {
                    System.out.println("este é um repedito que nao é a calda e nao esta na sequencia");
                    System.out.println("current: " + current.getElement());
                    System.out.println("elements seens: " + seenElements);

                    NodeDLL<Integer> previous = current.getPrevious();
                    previous.setNext(current.getNext());
                    current.getNext().setPrevious(previous);
                }
            }
            //System.out.println("current " + current.getElement() + " getting next " + current.getNext().getElement());
            current = current.getNext();
        }
    }
}
