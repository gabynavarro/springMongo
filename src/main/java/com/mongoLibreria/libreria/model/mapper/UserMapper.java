package com.mongoLibreria.libreria.model.mapper;

import com.mongoLibreria.libreria.model.Entity.User;
import com.mongoLibreria.libreria.model.reponse.UserRegisterRequest;
import com.mongoLibreria.libreria.model.reponse.UserRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
 

    public User userDto2Entity(UserRegisterRequest request) {
        return User.builder()
                .email(request.getEmail())
                .firstName(request.getFirst_name())
                .lastName(request.getLast_name())
                .password(passwordEncoder.encode(request.getPassword()))                
                .build();     
    }

    public UserRegisterResponse userEntity2Dto(User user) {
          return UserRegisterResponse.builder()
                  .id(user.getId())
                  .email(user.getEmail())
                  .firstName(user.getFirstName())
                  .lastName(user.getLastName())                 
                  .roles(user.getRoles())                  
                  .build();
    }
//
//    public User userDtoEntity(User entity, UserRequest request) {     
//        entity.setPassword(passwordEncoder.encode(request.getPassword()));
//        return entity;
//
//    }
//    
//    
//    public UserResponse convertTo(User userInstance) {
//        UserResponse userResponse = new UserResponse();
//        userResponse.setId(userInstance.getId());
//        return userResponse;
//    }
//    
//    public UserRoleResponse convertToUserRole(User user) {
//        UserRoleResponse userResponse = new UserRoleResponse();
//        userResponse.setId(user.getId());
//        return userResponse;
//    }
    
    
}
