package controller;

import com.mongoLibreria.libreria.model.Persona;
import com.mongoLibreria.libreria.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {
    private final PersonaService personaService;
    
    @PostMapping ("") 
    public void save(@RequestBody Persona persona){
        personaService.save(persona);
    }
    @GetMapping("")
    public String ver(){
        return "funciona";
    }
}
