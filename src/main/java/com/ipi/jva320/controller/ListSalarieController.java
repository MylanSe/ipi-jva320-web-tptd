package com.ipi.jva320.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipi.jva320.service.SalarieAideADomicileService;
import com.ipi.jva320.model.SalarieAideADomicile;

@Controller
public class ListSalarieController {
    @Autowired
    private SalarieAideADomicileService sas;
    @GetMapping(value = "/salaries")
    public String ListSalarie(final ModelMap model){
        List<SalarieAideADomicile> listS = sas.getSalaries();
        model.put("listSalarie", listS);
        return "list";
    }
}
