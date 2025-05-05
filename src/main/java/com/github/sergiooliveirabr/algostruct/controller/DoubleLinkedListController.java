package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert.InsertAtEndDLLStrategy;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert.InsertElementDLLStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/double-linked-list")
public class DoubleLinkedListController {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;
    private final InsertAtEndDLLStrategy insertAtEndDLLStrategy;

    @Autowired
    public DoubleLinkedListController(DoubleLinkedListService<Integer> doubleLinkedListService,
                                      InsertAtEndDLLStrategy insertAtEndDLLStrategy) {
        this.doubleLinkedListService = doubleLinkedListService;
        this.insertAtEndDLLStrategy = insertAtEndDLLStrategy;
    }

    @GetMapping("/page")
    public String showDoubleLinkedListPage(Model model) {

        model.addAttribute("list", "List:  " + doubleLinkedListService.getAllElementsFromDLL());
        model.addAttribute("size", "Size: " + doubleLinkedListService.size());

        return "double-linked-list";
    }

    @PostMapping("/insert")
    public String insertElement(@RequestParam int element) {

        insertAtEndDLLStrategy.insertElementDLL(element);
        return "redirect:/double-linked-list/page";
    }


}
