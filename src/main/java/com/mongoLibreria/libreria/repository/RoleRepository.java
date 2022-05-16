package com.mongoLibreria.libreria.repository;

import com.mongoLibreria.libreria.model.Entity.ERole;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongoLibreria.libreria.model.Entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
