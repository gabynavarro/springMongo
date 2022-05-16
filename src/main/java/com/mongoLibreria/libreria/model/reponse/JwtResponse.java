package com.mongoLibreria.libreria.model.reponse;

import com.mongoLibreria.libreria.model.Entity.Role;
import java.util.Set;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class JwtResponse {
	  
    private String token;
    private String email;
   private Set<Role> roles;


}
