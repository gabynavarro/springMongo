
package com.mongoLibreria.libreria.service.impl;

import com.mongoLibreria.libreria.model.Entity.Author;
import com.mongoLibreria.libreria.repository.AuthorRepository;
import com.mongoLibreria.libreria.repository.BaseRepository;
import com.mongoLibreria.libreria.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author, String> implements AuthorService{
  
    @Autowired
    private AuthorRepository authorRepository;
     public AuthorServiceImpl(AuthorRepository authorRepository, BaseRepository<Author, String> baseRepository) {
        super(baseRepository);
        this.authorRepository = authorRepository;
    }

}
