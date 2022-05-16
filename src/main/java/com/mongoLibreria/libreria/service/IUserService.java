package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.Entity.User;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;





public interface IUserService {
    
    User getInfoUser() throws NotFoundException;

}
