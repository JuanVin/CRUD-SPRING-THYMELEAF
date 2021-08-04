/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.democrud.controller;

import com.crud.democrud.model.Persona;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crud.democrud.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author juan
 */
@Controller
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    
    @RequestMapping(path="/")
    public String index(Model model){
        model.addAttribute("list", personaService.getAll());
        return "index";
    }
    
    @GetMapping("/adduser")
    public String save(Model model){
        return "add-user";
    }
     
    @GetMapping("/update-user/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        
        Persona persona = personaService.get(id);
        model.addAttribute("persona", persona);
        return "update-user";
        
    }
    
    @PostMapping("/update-user/{id}")
    public String updateUser(@PathVariable Long id, Persona persona, BindingResult result, Model model) {
        if (result.hasErrors()) {
            persona.setId(id);
            return "update-user";
        }
        personaService.save(persona);
        return "redirect:/";
    }
  
    @PostMapping("/adduser")
    public String save(Persona persona, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add-user";
        }
        personaService.save(persona);
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        personaService.delete(id);
        return "redirect:/";
    }
}
