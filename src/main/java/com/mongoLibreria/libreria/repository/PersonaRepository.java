
package com.mongoLibreria.libreria.repository;

import com.mongoLibreria.libreria.model.Entity.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String>{
    
}
