package com.mongoLibreria.libreria.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongoLibreria.libreria.model.Entity.User;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
