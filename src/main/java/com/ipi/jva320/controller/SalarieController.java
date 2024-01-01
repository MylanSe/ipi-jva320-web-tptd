package com.ipi.jva320.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.put("id", id);
        model.put("nom", sad.getNom());
        model.put("joursTravaillesAnneeN", sad.getJoursTravaillesAnneeN());
        model.put("congesPayesAcquisAnneeN", sad.getCongesPayesAcquisAnneeN());
        model.put("congesPayesPris", sad.getCongesPayesPris());
        model.put("joursTravaillesAnneeNMoins1", sad.getJoursTravaillesAnneeNMoins1());
        model.put("moisEnCours", sad.getMoisEnCours());
        model.put("moisDebutContrat", sad.getMoisDebutContrat());
        model.put("congesPayesAcquisAnneeNMoins1", sad.getCongesPayesAcquisAnneeNMoins1());
        model.put("congesPayesPrisAnneeNMoins1", sad.getCongesPayesPrisAnneeNMoins1());
        model.put("url", "/salaries/" + id);
        return "/detail_Salarie";
    }

    @PostMapping(value="/salaries/{id}")
    public String updateSalarieDomicile(SalarieAideADomicile salarie) throws SalarieException{
        sas.updateSalarieAideADomicile(salarie);
        return "/detail_Salarie";
    }

    @GetMapping(value="/salaries/aide/new")
    public String salarieDomicile() throws SalarieException{
        return "/detail_Salarie";
    }

    @PostMapping(value="/salaries/aide/new")
    public String creerSalarieDomicile(SalarieAideADomicile salarie) throws SalarieException{
        sas.creerSalarieAideADomicile(salarie);
        return "home";
    }

    @GetMapping(value="/salaries/{id}/delete")
    public String deleteSalarieDomicile(@PathVariable String id) throws SalarieException{
        sas.deleteSalarieAideADomicile(Long.parseLong(id));
        return "home";
    }

    @GetMapping(value="/salaries/search")
    public String getSalarie(@RequestParam("nom") String nom) throws SalarieException{
        if(sas.getSalaries(nom).size()==1){
            SalarieAideADomicile sad = sas.getSalaries(nom).get(0);
            Long id = sad.getId();
            return "redirect:/salaries/" + id;

        }
        else if(sas.getSalaries(nom).size()==0){
            String message = "aucun resultat";
            return "redirect:/error/" + message;
        }
        else{
            String message = "trop de résultat, soyez plus précis";
            return "redirect:error" + message;
        }
    }
}
