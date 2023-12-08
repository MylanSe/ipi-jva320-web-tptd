package com.ipi.jva320.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipi.jva320.exception.SalarieException;
import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;


@Controller
public class SalarieController {
    @Autowired
    
    private SalarieAideADomicileService sas;
    @GetMapping(value = "/salaries/{id}")
    public String Salarie(final ModelMap model, @PathVariable String id){
        SalarieAideADomicile sad = sas.getSalarie(Long.parseLong(id));
        model.put("id", sad.getId());
        model.put("nom", sad.getNom());
        model.put("joursTravaillesAnneeN", sad.getJoursTravaillesAnneeN());
        model.put("congesPayesAcquisAnneeN", sad.getCongesPayesAcquisAnneeN());
        model.put("congesPayesPris", sad.getCongesPayesPris());
        model.put("joursTravaillesAnneeNMoins1", sad.getJoursTravaillesAnneeNMoins1());
        model.put("moisEnCours", sad.getMoisEnCours());
        model.put("moisDebutContrat", sad.getMoisDebutContrat());
        return "detail_Salarie";
    }

    @GetMapping(value="salaries/aide/new")
    public String salarieDomicile() throws SalarieException{
        return "detail_Salarie";
    }

    @PostMapping(value="salaries/aide/new")
    public String creerSalarieDomicile(SalarieAideADomicile salarie) throws SalarieException{
        sas.creerSalarieAideADomicile(salarie);
        return "redirect:/salaries/detail_Salarie";
    }
}
