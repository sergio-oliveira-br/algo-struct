package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.delete.DeleteAtGivenIndexService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.delete.DeleteFirstElementService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.delete.DeleteLastElementService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.insert.InsertAtGivenIndexService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.insert.InsertOrchestratorServiceSLL;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.reverse.ReverseListService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.search.FindNodeService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.search.FindValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/linked-list")
public class LinkedListController {

    private final SinglyLinkedListService<Integer> singlyLinkedListService;
    private final DeleteFirstElementService<Integer> deleteFirstElementService;
    private final DeleteLastElementService<Integer> deleteLastElementService;
    private final FindValueService<Integer> findValueService;
    private final FindNodeService<Integer> findNodeService;
    private final InsertAtGivenIndexService<Integer> insertAtGivenIndexService;
    private final DeleteAtGivenIndexService<Integer> deleteAtGivenIndexService;
    private final ReverseListService<Integer> reverseListService;
    private final InsertOrchestratorServiceSLL insertOrchestratorServiceSLL;

    @Autowired
    public LinkedListController(SinglyLinkedListService<Integer> singlyLinkedListService,
                                DeleteFirstElementService<Integer> deleteFirstElementService,
                                DeleteLastElementService<Integer> deleteLastElementService,
                                FindValueService<Integer> findValueService,
                                FindNodeService<Integer> findNodeService,
                                InsertAtGivenIndexService<Integer> insertAtGivenIndexService,
                                DeleteAtGivenIndexService<Integer> deleteAtGivenIndexService,
                                ReverseListService<Integer> reverseListService, InsertOrchestratorServiceSLL insertOrchestratorServiceSLL) {

        this.singlyLinkedListService = singlyLinkedListService;
        this.deleteFirstElementService = deleteFirstElementService;
        this.deleteLastElementService = deleteLastElementService;
        this.findValueService = findValueService;
        this.findNodeService = findNodeService;
        this.insertAtGivenIndexService = insertAtGivenIndexService;
        this.deleteAtGivenIndexService = deleteAtGivenIndexService;
        this.reverseListService = reverseListService;
        this.insertOrchestratorServiceSLL = insertOrchestratorServiceSLL;
    }

    @GetMapping("/page")
    public String showLinkedListPage(Model model) {

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("mySize", "Size of the List: " + singlyLinkedListService.size());


        //This is related to Search for an Element
        if(model.containsAttribute("value")) {

            int value = (int) model.getAttribute("value");
            boolean searchResult = (boolean) model.getAttribute("searchResult");

            model.addAttribute("searchResult", searchResult);
            model.addAttribute("nextNode", findNodeService.findNextNode(value));
            model.addAttribute("node", "Searching for Node " + value);
        }

        //This is related to Insert At Given Index
        else if (model.containsAttribute("nodeElementAtIndex")) {

            String message = (String) model.getAttribute("nodeElementAtIndex");
            model.addAttribute("nodeElementAtIndex", message);
        }

        return "linked-list";
    }


    @PostMapping("/insert")
    public String insertAndDisplay(@RequestParam int element,
                                   @RequestParam String algorithm) {

        insertOrchestratorServiceSLL.insertOrchestrator(element, algorithm);

        return "redirect:/linked-list/page";
    }

    @PostMapping("/delete")
    public String deleteAnElement(@RequestParam String deleteAlgorithm) {

        if(deleteAlgorithm.equals("deleteFirstElement")){
            deleteFirstElementService.deleteElement();
        }
        else{
            deleteLastElementService.deleteElement();
        }
        return "redirect:/linked-list/page";
    }

    @PostMapping("/find")
    public String findByValue(@RequestParam int value, RedirectAttributes redirectAttributes) {

        boolean searchResult = findValueService.findByValue(value);

        //This will send the info to view according the PRG Pattern
        redirectAttributes.addFlashAttribute("searchResult", searchResult);
        redirectAttributes.addFlashAttribute("value", value);

        return "redirect:/linked-list/page";
    }

    @PostMapping("/insert-at-given-index")
    public String insertAtGivenIndex(RedirectAttributes redirectAttributes,
                                     @RequestParam int indexNode,
                                     @RequestParam int nodeElement) {

        insertAtGivenIndexService.InsertAtGivenIndex(indexNode, nodeElement);

        //This will send the info to view according the PRG Pattern
        redirectAttributes.addFlashAttribute("nodeElementAtIndex",
                "Inserting the element " + nodeElement + " at index " + indexNode);

        return "redirect:/linked-list/page";
    }

    @PostMapping("/delete-at-given-index")
    public String deleteAtGivenIndex(RedirectAttributes redirectAttributes,
                                     @RequestParam int indexNode) {

        deleteAtGivenIndexService.deleteAtGivenIndex(indexNode);

        //This will send the info to view according the PRG Pattern
        redirectAttributes.addFlashAttribute("nodeElementAtIndex",
                "Deleting the element at index " + indexNode);

        return "redirect:/linked-list/page";
    }

    @GetMapping("/reverse-list")
    public String reverseList(RedirectAttributes redirectAttributes) {
        reverseListService.reverseList();

        //This will send the info to view according the PRG Pattern
        redirectAttributes.addFlashAttribute("nodeElementAtIndex", "Reversed list");

        return "redirect:/linked-list/page";
    }
}
