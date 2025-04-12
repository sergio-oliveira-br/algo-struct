package com.github.sergiooliveirabr.algostruct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/linked-list")
public class LinkedList {

    @GetMapping("/page")
    public String showLinkedListPage() {
        return "linked-list";
    }
}
