package com.tracker.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class IndexController {

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("someAttribute", "List of customers");
        return "list-customer";
    }
}
