
package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.Persona;
import com.mongoLibreria.libreria.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaService {
    private final PersonaRepository personaRepository;
    
    public void save(Persona persona){
        personaRepository.save(persona);
    }
}
