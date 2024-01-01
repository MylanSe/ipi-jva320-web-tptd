package com.ipi.jva320.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ErrorController {
    @GetMapping(value="/error/{message}")
    public String Error(final ModelMap model, @PathVariable String message){
        model.put("msg", message);
        System.out.println(message);
        return "redirect:/pageError.html";
    }
}
