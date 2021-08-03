/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.democrud.controller;

import com.crud.democrud.model.Persona;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.democrud.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author juan
 */
@RestController
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    
    @RequestMapping(path="/")
    public String index(Model model){
        model.addAttribute("list", personaService.getAll());
        return "index";
    }
    
    @GetMapping("/save/{id}")
    public String save(@PathVariable Long id, Model model){
        if (id != null){
            model.addAttribute("persona", personaService.get(id));
        }
        return "save";
    }
    
    @PostMapping("/save/{id}")
    public String save(Persona persona, Model model){
        personaService.save(persona);
        return "redirect:/";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        personaService.delete(id);
        return "redirect:/";
    }
}
