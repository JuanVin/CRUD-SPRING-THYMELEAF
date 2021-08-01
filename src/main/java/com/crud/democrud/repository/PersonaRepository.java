/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.democrud.repository;

import com.crud.democrud.model.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan
 */
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    
}
