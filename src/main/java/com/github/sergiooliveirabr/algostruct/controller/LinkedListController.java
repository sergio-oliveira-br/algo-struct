package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.InsertAtBeginningService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.InserteAtEndService;
import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/linked-list")
public class LinkedListController {

    private final SinglyLinkedListService singlyLinkedListService;
    private final InserteAtEndService<Integer> inserteAtEndService;
    private final InsertAtBeginningService<Integer> insertAtBeginningService;

    @Autowired
    public LinkedListController(SinglyLinkedListService singlyLinkedListService,
                                InserteAtEndService<Integer> inserteAtEndService,
                                InsertAtBeginningService<Integer> insertAtBeginningService) {

        this.singlyLinkedListService = singlyLinkedListService;
        this.inserteAtEndService = inserteAtEndService;
        this.insertAtBeginningService = insertAtBeginningService;
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
        return "linked-list";
    }
}
