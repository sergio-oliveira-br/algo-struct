package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.delete.DeleteFirstElementService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.delete.DeleteLastElementService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.insert.InsertAtBeginningService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.insert.InserteAtEndService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.search.FindByValueService;
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

    private final SinglyLinkedListService singlyLinkedListService;
    private final InserteAtEndService<Integer> inserteAtEndService;
    private final InsertAtBeginningService<Integer> insertAtBeginningService;
    private final DeleteFirstElementService<Integer> deleteFirstElementService;
    private final DeleteLastElementService<Integer> deleteLastElementService;
    private final FindByValueService<Integer> findByValueService;

    @Autowired
    public LinkedListController(SinglyLinkedListService singlyLinkedListService,
                                InserteAtEndService<Integer> inserteAtEndService,
                                InsertAtBeginningService<Integer> insertAtBeginningService,
                                DeleteFirstElementService<Integer> deleteFirstElementService,
                                DeleteLastElementService<Integer> deleteLastElementService,
                                FindByValueService<Integer> findByValueService) {

        this.singlyLinkedListService = singlyLinkedListService;
        this.inserteAtEndService = inserteAtEndService;
        this.insertAtBeginningService = insertAtBeginningService;
        this.deleteFirstElementService = deleteFirstElementService;
        this.deleteLastElementService = deleteLastElementService;
        this.findByValueService = findByValueService;
    }

    @GetMapping("/page")
    public String showLinkedListPage() {
        return "linked-list";
    }


    @PostMapping("/insert")
    public String insertAndDisplay(Model model,
                                   @RequestParam int element,
                                   @RequestParam String algorithm) {

        if(Objects.equals(algorithm, "insertAtEndService")){
            inserteAtEndService.insertElement(element);
        }
        else{
            insertAtBeginningService.insertElement(element);
        }

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("mySize",
                "Size of the List: " + singlyLinkedListService.size());
        return "linked-list";
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

        boolean searchResult = findByValueService.findByValeu(value);

        model.addAttribute("myList", singlyLinkedListService.toString());
        model.addAttribute("mySize",
                "Size of the List: " + singlyLinkedListService.size());
        model.addAttribute("searchResult", searchResult);
        return "linked-list";
    }
}
