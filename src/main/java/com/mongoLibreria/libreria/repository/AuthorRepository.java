
package com.mongoLibreria.libreria.repository;

import com.mongoLibreria.libreria.model.Entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseRepository<Author, String>{
    
}
