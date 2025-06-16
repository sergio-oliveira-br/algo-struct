package com.github.sergiooliveirabr.algostruct.controller;

import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.DoubleLinkedListService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete.DeleteByValueDLLService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.delete.DeleteOrchestratorDLLService;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.duplicate.RemoveDuplicatesInterface;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert.InsertAtGivenIndexDLLStrategy;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.insert.InsertOrchestratorServiceDLL;
import com.github.sergiooliveirabr.algostruct.service.doublelinkedlist.search.GetElementByIndexDLLStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/double-linked-list")
public class DoubleLinkedListController {

    private final DoubleLinkedListService<Integer> doubleLinkedListService;
    private final InsertOrchestratorServiceDLL insertOrchestratorServiceDLL;
    private final InsertAtGivenIndexDLLStrategy insertAtGivenIndexDLLStrategy;
    private final DeleteOrchestratorDLLService<Integer> deleteOrchestratorDLLService;
    private final DeleteByValueDLLService deleteByValueDLLService;
    private final GetElementByIndexDLLStrategy getElementByIndexDLLStrategy;
    private final RemoveDuplicatesInterface removeDuplicatesInterface;

    @Autowired
    public DoubleLinkedListController(DoubleLinkedListService<Integer> doubleLinkedListService,
                                      InsertOrchestratorServiceDLL insertOrchestratorServiceDLL,
                                      InsertAtGivenIndexDLLStrategy insertAtGivenIndexDLLStrategy,
                                      DeleteOrchestratorDLLService<Integer> deleteOrchestratorDLLService,
                                      DeleteByValueDLLService deleteByValueDLLService,
                                      GetElementByIndexDLLStrategy getElementByIndexDLLStrategy,
                                      RemoveDuplicatesInterface removeDuplicatesInterface) {

        this.doubleLinkedListService = doubleLinkedListService;
        this.insertOrchestratorServiceDLL = insertOrchestratorServiceDLL;
        this.insertAtGivenIndexDLLStrategy = insertAtGivenIndexDLLStrategy;
        this.deleteOrchestratorDLLService = deleteOrchestratorDLLService;
        this.deleteByValueDLLService = deleteByValueDLLService;
        this.getElementByIndexDLLStrategy = getElementByIndexDLLStrategy;
        this.removeDuplicatesInterface = removeDuplicatesInterface;
    }

    @GetMapping("/page")
    public String showDoubleLinkedListPage(Model model) {

        model.addAttribute("list", "List:  " + doubleLinkedListService.getAllElementsFromDLL());
        model.addAttribute("size", "Size: " + doubleLinkedListService.size());
        model.containsAttribute("indexElement");

        //it makes the button do delete enable or disable
        model.addAttribute("mysize", doubleLinkedListService.size());

        model.containsAttribute("errorMessage");

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
    public String deleteAnElement(@RequestParam String strategy) {
        deleteOrchestratorDLLService.deleteOrchestratorDLL(strategy);
        return "redirect:/double-linked-list/page";
    }

    @PostMapping("/delete-by-value")
    public String deleteAnElementByValueDLL(@RequestParam int element) {
        deleteByValueDLLService.deleteByValueDLL(element);
        return "redirect:/double-linked-list/page";
    }

    @PostMapping("/get-element-by-index")
    public String getElementByIndexDLL(@RequestParam int index,
                                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("indexElement",
                "Index " + index + " is " +  getElementByIndexDLLStrategy.getElement(index));
        return "redirect:/double-linked-list/page";
    }

    @PostMapping("/remove-duplicates")
    public String removeDuplicates() {
        removeDuplicatesInterface.removeDuplicatesDLLStrategy();
        return "redirect:/double-linked-list/page";
    }
}
