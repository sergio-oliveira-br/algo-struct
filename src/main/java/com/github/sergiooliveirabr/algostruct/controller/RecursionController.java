package com.github.sergiooliveirabr.algostruct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recursion")
public class RecursionController {

    @GetMapping("/page")
    public String showRecursionPage(Model model) {
        return "recursion";
    }
}
