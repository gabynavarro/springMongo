
package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.Persona;
import com.mongoLibreria.libreria.repository.PersonaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaService {
    private final PersonaRepository personaRepository;
    
    public void save(Persona persona){
        personaRepository.save(persona);
    }
    public List<Persona> findAll(){      
        return personaRepository.findAll();
        
    }
    
    public  Persona findById(String id){
        return personaRepository.findById(id).orElseThrow();
    }
    public void delete(String id) {
         personaRepository.deleteById(id);
    }
}
