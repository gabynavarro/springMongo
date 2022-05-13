package com.mongoLibreria.libreria.model.reponse;

import com.mongoLibreria.libreria.model.Entity.Role;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterResponse {

    private String id;
    private String email;  
    private String token;
    private String firstName;
    private String lastName;
    private List<Role> roles;
   


}
