package com.mongoLibreria.libreria.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Persona")
@Data
public class Persona {
    @Id
    private String id ;
    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;
    
    
}
