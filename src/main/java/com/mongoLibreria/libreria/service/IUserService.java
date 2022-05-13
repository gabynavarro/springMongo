package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.Entity.User;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface IUserService {
    
    User getInfoUser() throws NotFoundException;
    void delete(String id)throws EntityNotFoundException;
//    UserResponse update(Long id, UserRequest request)throws NotFoundException;
//    UserResponse getById(Long id);
//    List<UserResponse> getAllUser();
//    UserRoleResponse updateRoles(Long id , List<Role> roles);
//    List<UserResponse> getByFilters(String email, String first_name, String last_name, String dni);
}
