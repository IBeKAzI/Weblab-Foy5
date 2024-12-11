package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.CustommerService;

@Controller
public class OperationController {
    @Autowired
    CustommerService custommerService;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("CustommerList", custommerService.getAllCustommers());
        return "/index";
    }

}
