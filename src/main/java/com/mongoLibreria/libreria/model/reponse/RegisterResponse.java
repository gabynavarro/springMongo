package com.mongoLibreria.libreria.model.reponse;

import com.mongoLibreria.libreria.model.Entity.Role;
import java.util.Set;
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
public class RegisterResponse {

    private String id;
    private String email;  
    private String token;
    private String username;
    private Set<Role> roles;
   


}
