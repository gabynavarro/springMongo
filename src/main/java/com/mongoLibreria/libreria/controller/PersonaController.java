package com.mongoLibreria.libreria.controller;

import com.mongoLibreria.libreria.model.Entity.Persona;
import com.mongoLibreria.libreria.service.impl.PersonaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PersonaController {
    private final PersonaService personaService;
    
    @PostMapping ("/add") 
    public void save(@RequestBody Persona persona){
        personaService.save(persona);
    }
    @GetMapping("/list")
    public List<Persona> findAll(){
        return personaService.findAll();
    }
    @GetMapping("/{id}")
    public Persona findById(@PathVariable String id){
        return personaService.findById(id);
    }
    @DeleteMapping("/{id}")
    public  void delteById(@PathVariable String id){
        personaService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Persona persona){
        personaService.save(persona);
    }
}
