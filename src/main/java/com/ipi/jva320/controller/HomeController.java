package com.ipi.jva320.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ipi.jva320.service.SalarieAideADomicileService;

// HomeController.java :
@Controller
public class HomeController {
    
    @Autowired
    private SalarieAideADomicileService s;
    @GetMapping(value = "/")
    public String home(final ModelMap model) {
        Long nb = s.countSalaries();
        String rep = String.valueOf(nb);
        model.put("nbSalarie", rep);
        return "home";
    }
    

    
}
