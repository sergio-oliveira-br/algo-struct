package com.github.sergiooliveirabr.algostruct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/binary-search-tree")
public class BinarySearchTreeController {

    @GetMapping("/page")
    public String showBSTPage(Model model) {
        return "binary-search-tree";
    }
}
