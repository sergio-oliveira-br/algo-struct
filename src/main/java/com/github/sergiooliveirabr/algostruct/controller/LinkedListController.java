package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.delete.DeleteAtGivenIndexService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.delete.DeleteFirstElementService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.delete.DeleteLastElementService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.insert.InsertAtBeginningService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.insert.InsertAtGivenIndexService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.insert.InserteAtEndService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.reverse.ReverseListService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.search.FindNodeService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.search.FindValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/linked-list")
public class LinkedListController {

    private final SinglyLinkedListService<Integer> singlyLinkedListService;
    private final InserteAtEndService<Integer> inserteAtEndService;
    private final InsertAtBeginningService<Integer> insertAtBeginningService;
    private final DeleteFirstElementService<Integer> deleteFirstElementService;
    private final DeleteLastElementService<Integer> deleteLastElementService;
    private final FindValueService<Integer> findValueService;
    private final FindNodeService<Integer> findNodeService;
    private final InsertAtGivenIndexService<Integer> insertAtGivenIndexService;
    private final DeleteAtGivenIndexService<Integer> deleteAtGivenIndexService;
    private final ReverseListService<Integer> reverseListService;

    @Autowired
    public LinkedListController(SinglyLinkedListService<Integer> singlyLinkedListService,
                                InserteAtEndService<Integer> inserteAtEndService,
                                InsertAtBeginningService<Integer> insertAtBeginningService,
                                DeleteFirstElementService<Integer> deleteFirstElementService,
                                DeleteLastElementService<Integer> deleteLastElementService,
                                FindValueService<Integer> findValueService,
                                FindNodeService<Integer> findNodeService,
                                InsertAtGivenIndexService<Integer> insertAtGivenIndexService,
                                DeleteAtGivenIndexService<Integer> deleteAtGivenIndexService,
                                ReverseListService<Integer> reverseListService) {

        this.singlyLinkedListService = singlyLinkedListService;
        this.inserteAtEndService = inserteAtEndService;
        this.insertAtBeginningService = insertAtBeginningService;
        this.deleteFirstElementService = deleteFirstElementService;
        this.deleteLastElementService = deleteLastElementService;
        this.findValueService = findValueService;
        this.findNodeService = findNodeService;
        this.insertAtGivenIndexService = insertAtGivenIndexService;
        this.deleteAtGivenIndexService = deleteAtGivenIndexService;
        this.reverseListService = reverseListService;
    }

    @GetMapping("/page")
    public String showLinkedListPage(Model model) {

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("mySize",
                "Size of the List: " + singlyLinkedListService.size());
        return "linked-list";
    }


    @PostMapping("/insert")
    public String insertAndDisplay(@RequestParam int element,
                                   @RequestParam String algorithm) {

        if(Objects.equals(algorithm, "insertAtEndService")){
            inserteAtEndService.insertElement(element);
        }
        else{
            insertAtBeginningService.insertElement(element);
        }
        return "redirect:/linked-list/page";
    }

    @PostMapping("/delete")
    public String deleteFirstElement(Model model,
                                     @RequestParam String deleteAlgorithm) {

        if(deleteAlgorithm.equals("deleteFirstElement")){
            deleteFirstElementService.deleteElement();
        }
        else{
            deleteLastElementService.deleteElement();
        }

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("mySize",
                "Size of the List: " + singlyLinkedListService.size());

        return "linked-list";
    }

    @PostMapping("/find")
    public String findByValue(Model model, @RequestParam int value) {

        boolean searchResult = findValueService.findByValue(value);

        if (searchResult) {
            findNodeService.findNextNode(value);
        }

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("mySize",
                "Size of the List: " + singlyLinkedListService.size());
        model.addAttribute("searchResult", searchResult);
        model.addAttribute("nextNode", findNodeService.findNextNode(value));
        model.addAttribute("node", "Searching for Node " + value);
        return "linked-list";
    }

    @PostMapping("/insert-at-given-index")
    public String insertAtGivenIndex(Model model,
                                     @RequestParam int indexNode,
                                     @RequestParam int nodeElement) {

        insertAtGivenIndexService.InsertAtGivenIndex(indexNode, nodeElement);

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("mySize", "Size of the List: " + singlyLinkedListService.size());
        model.addAttribute("nodeElementAtIndex", "Inserting the element " + nodeElement + " at index " + indexNode);

        return "linked-list";
    }

    @PostMapping("/delete-at-given-index")
    public String deleteAtGivenIndex(Model model,
                                     @RequestParam int indexNode) {

        deleteAtGivenIndexService.deleteAtGivenIndex(indexNode);

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("mySize", "Size of the List: " + singlyLinkedListService.size());
        model.addAttribute("nodeElementAtIndex", "Deleting the element at index " + indexNode);

        return "linked-list";
    }

    @GetMapping("/reverse-list")
    public String reverseList(Model model) {
        reverseListService.reverseList();

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("reversedList", singlyLinkedListService.toString());
        model.addAttribute("mySize", "Size of the List: " + singlyLinkedListService.size());
        model.addAttribute("nodeElementAtIndex", "Reversed list");

        return "linked-list";
    }
}
