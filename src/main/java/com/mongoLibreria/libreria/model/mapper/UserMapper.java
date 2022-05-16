package com.mongoLibreria.libreria.model.mapper;

import com.mongoLibreria.libreria.model.Entity.User;
import com.mongoLibreria.libreria.model.reponse.JwtResponse;
import com.mongoLibreria.libreria.model.reponse.RegisterResponse;
import com.mongoLibreria.libreria.model.request.SignupRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
 

    public User userDto2Entity(SignupRequest request) {
        return User.builder()
                .email(request.getEmail())
                .username(request.getUsername())                
                .password(passwordEncoder.encode(request.getPassword()))                
                .build();     
    }
////
    public JwtResponse userEntity2Dto(User user, String jwt) {
          return JwtResponse.builder()
                  .token(jwt)                  
                  .email(user.getEmail())
                  .roles(user.getRoles())
                  .build();
    }
    public RegisterResponse userEntityRes(User user){
        return RegisterResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())                
                .roles(user.getRoles())
                .build();
    }
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
