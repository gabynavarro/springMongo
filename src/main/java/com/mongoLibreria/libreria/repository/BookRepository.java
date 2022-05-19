package com.mongoLibreria.libreria.repository;

import com.mongoLibreria.libreria.model.Entity.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends BaseRepository<Book, String>{
    
}
