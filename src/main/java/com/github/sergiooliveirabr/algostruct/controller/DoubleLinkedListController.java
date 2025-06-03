package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete.DeleteLastElementDLLStrategy;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert.InsertAtGivenIndexDLLStrategy;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert.InsertOrchestratorServiceDLL;
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
    private final InsertOrchestratorServiceDLL insertOrchestratorServiceDLL;
    private final InsertAtGivenIndexDLLStrategy insertAtGivenIndexDLLStrategy;
    private final DeleteLastElementDLLStrategy<Integer> deleteLastElementDLLStrategy;

    @Autowired
    public DoubleLinkedListController(DoubleLinkedListService<Integer> doubleLinkedListService,
                                      InsertOrchestratorServiceDLL insertOrchestratorServiceDLL,
                                      InsertAtGivenIndexDLLStrategy insertAtGivenIndexDLLStrategy, DeleteLastElementDLLStrategy<Integer> deleteLastElementDLLStrategy) {
        this.doubleLinkedListService = doubleLinkedListService;
        this.insertOrchestratorServiceDLL = insertOrchestratorServiceDLL;
        this.insertAtGivenIndexDLLStrategy = insertAtGivenIndexDLLStrategy;
        this.deleteLastElementDLLStrategy = deleteLastElementDLLStrategy;
    }

    @GetMapping("/page")
    public String showDoubleLinkedListPage(Model model) {

        model.addAttribute("list", "List:  " + doubleLinkedListService.getAllElementsFromDLL());
        model.addAttribute("size", "Size: " + doubleLinkedListService.size());

        return "double-linked-list";
    }

    @PostMapping("/insert")
    public String insertElement(@RequestParam int element, @RequestParam String insertStrategy) {
        insertOrchestratorServiceDLL.insertElementDLLStrategyMap(element, insertStrategy);
        return "redirect:/double-linked-list/page";
    }

    @PostMapping("/insert-by-index")
    public String insertElementByGivenIndexDLL(@RequestParam int element, @RequestParam int index) {
        insertAtGivenIndexDLLStrategy.insertElementByIndexDLL(element, index);
        return "redirect:/double-linked-list/page";
    }

    @PostMapping("/delete")
    public String deleteAnElement() {
        deleteLastElementDLLStrategy.deleteElementDLL();
        return "redirect:/double-linked-list/page";
    }
}
