package com.github.sergiooliveirabr.algostruct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/double-linked-list")
public class DoubleLinkedListController {

    @GetMapping("/page")
    public String showDoubleLinkedListPage() {
        return "double-linked-list";
    }
}
