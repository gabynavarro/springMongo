package com.mongoLibreria.libreria.repository;

import com.mongoLibreria.libreria.model.Entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
    
}
