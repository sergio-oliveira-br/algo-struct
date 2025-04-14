package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.linkedlist.SinglyLinkedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/linked-list")
public class LinkedListController {

    private final SinglyLinkedListService singlyLinkedListService;

    @Autowired
    public LinkedListController(SinglyLinkedListService singlyLinkedListService) {
        this.singlyLinkedListService = singlyLinkedListService;
    }

    @GetMapping("/page")
    public String showLinkedListPage() {
        return "linked-list";
    }


    @PostMapping("/insert-at-end")
    public String insertAndDisplay(Model model, @RequestParam int element) {

        singlyLinkedListService.insertAtEnd(element);

        model.addAttribute("myList", singlyLinkedListService.toString());
        return "linked-list";
    }
}
