package com.ipi.jva320.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

// HomeController.java :
@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String home(final ModelMap model) {
        int count = 25;
        model.put("nbSalarie", count);
        return "home";
    }

    public String 
}
