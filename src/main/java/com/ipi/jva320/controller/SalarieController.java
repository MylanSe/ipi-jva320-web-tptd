package com.ipi.jva320.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalarieController {
    @GetMapping(value = "/salaries/1")
    public String Salarie(){
        return "detail_Salarie";
    }
}
