/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crud.democrud.service.imp;

import com.crud.democrud.commons.GenericServiceImpl;
import com.crud.democrud.service.PersonaService;
import com.crud.democrud.model.Persona;
import com.crud.democrud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author juan
 */
@Service
public class PersonaServiceImp extends GenericServiceImpl<Persona, Long> implements PersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;
            
    @Override
    public CrudRepository<Persona, Long> getRepository() {
        return personaRepository;
    }
}
