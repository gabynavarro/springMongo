package com.mongoLibreria.libreria.repository;

import com.mongoLibreria.libreria.model.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository <User, String> {
    User findByEmail(String email);
}
