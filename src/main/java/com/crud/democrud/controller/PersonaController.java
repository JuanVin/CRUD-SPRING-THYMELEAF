/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.democrud.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.democrud.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
}
